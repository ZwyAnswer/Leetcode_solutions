/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {  //注意无向图中，一条边只表示一次，即
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

/**
 * 复制无向图，同图的遍历一样，可以使用DFS和BFS两种遍历策略
 * 题目地址：https://leetcode.com/problems/clone-graph/
 * 相似题目：Copy List with Random Pointer
**/
public class Solution {
    /**
     * DFS复制
     * 注意HashMap的使用，终止递归的条件。此处Map的作用类似于遍历中的visited属性作用
    **/
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> visit = new HashMap<>();  //使用map来映射新旧结点
        return dfs(node, visit);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> visit) {
        if(visit.containsKey(node)) return visit.get(node);  //使用map来避免含环的图无限递归
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        visit.put(node,copyNode);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            copyNode.neighbors.add(dfs(neighbor,visit));
        }
        return copyNode;
    }

    /**
     * BFS复制
     * 注意队列的使用
    **/
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<> ();
        Map<UndirectedGraphNode,UndirectedGraphNode> visit = new HashMap<> ();
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        visit.put(node,copyNode);
        queue.add(node);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode now = queue.poll();
            for(UndirectedGraphNode neighbor : now.neighbors) {
                if(visit.containsKey(neighbor)) {  //如果是已建立结点，则直接加入当前结点的邻居结点中
                    visit.get(now).neighbors.add(visit.get(neighbor));
                } else {  //否则，新建结点，加入队列。
                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                    visit.get(now).neighbors.add(copy);
                    visit.put(neighbor,copy);
                    queue.add(neighbor);
                }
            }
        }
        return copyNode;
    }
}