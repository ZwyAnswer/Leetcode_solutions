/**
 * 实现支持插入字符串单词和搜索字符串(含通配符.)方法的数据结构
 * 题目地址：https://leetcode.com/problems/add-and-search-word-data-structure-design/
**/
public class WordDictionary {

    /**
     * 在原Trie树的基础上，对search方法进行修改，使其支持通配符.
    **/
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    //深度优先遍历进行查找，K代表深度， node代表当前查找的Trie树节点
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("");   
        if (chs[k] != '.') {  //不是通配符，即a-z。正常Trie树搜索即可
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {  //依次匹配当前结点后继续递归
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}