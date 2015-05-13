/**
	题目地址：https://leetcode.com/problems/implement-trie-prefix-tree/
	实现Trie字典树。其主要特点有：
	根节点不包含字符，除根节点外每一个节点都只包含一个字符； 
	从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串； 
	每个节点的所有子节点包含的字符都不相同。
**/

class TrieNode {
    // Initialize your data structure here.
    final int SIZE = 26;   //题目说，输入只有a-z的小写组合
    TrieNode[] sons;  //树分支节点
    boolean isLeaf;  //是否为叶节点，可以用来判定是否查找到底
    char value;
    
	//此处对TrieNode属性域的权限简化成默认的包权限，实际中应该写为private并添加对应的Setter/getter
    public TrieNode() {
        sons = new TrieNode[SIZE];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if( word == null || word.length() == 0) return;
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int pos = c - 'a';
            if( node.sons[pos] == null) {  //插入对应树节点
                node.sons[pos] = new TrieNode();
                node.sons[pos].value = c;
            } 
            node = node.sons[pos];  //迭代
        }
        node.isLeaf = true;  //此时跳出循环，已是叶节点
    }
	
	// Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return (node != null) && node.isLeaf;  //如果树叶节点存在，则是搜索到底了。
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }
    
	/**
		因为不论查找最长前缀还是搜索完整单词，均涉及树节点的查找，故单独出一个查找节点的函数
	**/
    private TrieNode findNode(String s){
        if( s == null || s.length() == 0) return null;
        TrieNode node = root;
        for(char c: s.toCharArray()){
            int pos = c - 'a';
            if(node.sons[pos] == null)
                return null;
            node = node.sons[pos];
        }
        return node;
    }
    
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");