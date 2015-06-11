# 图的遍历
	同样的深度优先、广度优先策略也常用在树的问题中，以及回溯算法设计中。
	选择DFS还是BFS，要根据问题的特点来权衡利弊。

## DFS

DFS写法简单，但有时效率低。如果要访问图中所有结点，或访问最少的结点直至找到想找的结点可以考虑DSF。
如果图的规模大，离最初结点远时想随时退出，DFS则可能效率不佳

<!-- lang:java -->
	void search(Node root) {
		if(root == null) return;
		visit(root);
		root.visited = true;
		for( Node n : root.adjacent) {
			if(n.visited == false)
				search(n);
			}
		}
	}
	
## BFS

BFS实现的关键在于队列的使用

<!-- lang:java -->
	void search(Node root) {
		if(root == null) return;
		Queue<Node> queue = new LinkedList<> ();
		visit(root);
		root.visited = true;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for( Node node : n.adjacent) {
				if(node.visited == false) {
					visit(node);
					node.visited = true;
					queue.add(node);
				}
			}
		}
	}
	
# 图的表示

图可以用Edge list， Adjacency Matrix, Adjacency list来表示，具体可以参考[这里](https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs)
