/**
 * 给定字符矩阵和一个字符串数组，返回能在矩阵中找到的字符串列表
 * 如果使用79题的方法，会出现TLE，故要使用Trie树。
 * 题目地址：https://leetcode.com/problems/word-search-ii/
**/
public class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<> ();
        Trie trie = new Trie();
        for( String s : words) trie.insert(s);    //构建Trie树
        boolean[][] visited = new boolean[board.length][board[0].length];  //访问标记
            
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                find(board, "", visited, i, j, result, trie);
            }
        }
        return new ArrayList(result);
    }
    
    /**
     * 利用Trie树来查找字符串
     * word代表当前遍历构建的字符串，i j代表从i行j列开始。visited对应每个字符是否访问过。
    **/
    private void find(char[][] board, String word, boolean[][] visited, int i, int j, Set<String> result, Trie trie) {;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;  //下标越界 终止递归
        if(visited[i][j]) return;  //若是已访问过，则终止递归
        word += board[i][j];  //加入目前的字符
        if(!trie.startWith(word)) return;  //如果没有以当前字符串开始的单词，则终止递归
        if(trie.search(word)) result.add(word);  //能查找到，则添加进结果集
        
        visited[i][j] = true;
        find(board, word, visited, i-1, j, result, trie);
        find(board, word, visited, i+1, j, result, trie);
        find(board, word, visited, i, j-1, result, trie);
        find(board, word, visited, i, j+1, result, trie);
        visited[i][j] = false;
    }

    //Trie树结点
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";  //如果是叶节点，保存对应的字符串
        
        public TrieNode() {
            
        }
    }

    //定义Trie树，可以参考208题
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        //向Trie树中插入字符串
        public void insert(String word) {
            TrieNode node = root;
            for( char c : word.toCharArray()) {
                if(node.children[c-'a'] == null) {
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = word;  
        }
        
        //查找Trie树
        public boolean search(String word) {
            TrieNode node = root;
            for( char c : word.toCharArray()) {
                if(node.children[c-'a'] == null)
                    return false;
                node = node.children[c-'a'];
            }
            return node.word.equals(word);
        }
        
        //查找Trie树的前缀词
        public boolean startWith(String word) {
            TrieNode node = root;
            for( char c : word.toCharArray()) {
                if(node.children[c-'a'] == null)
                    return false;
                node = node.children[c-'a'];
            }
            return true;
        }
    }
}