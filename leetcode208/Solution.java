package leetcode.leetcode208;

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('/');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] cs = word.toCharArray();
        TrieNode p = root;
        for(char c : cs) {
            int index = c - 'a';
            if(p.childNodes[index]==null){
                p.childNodes[index] = new TrieNode(c);
            }
            p = p.childNodes[index];
        }
        p.isEnding = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        TrieNode p = root;
        for(char c : cs) {
            int index = c - 'a';
            if(p.childNodes[index] == null){
                return false;
            }
            p = p.childNodes[index];
        }
        return p.isEnding;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        TrieNode p = root;
        for(char c : cs) {
            int index = c - 'a';
            if(p.childNodes[index] == null){
                return false;
            }
            p = p.childNodes[index];
        }
        return true;
    }
}

class TrieNode {
    public char data;
    public TrieNode[] childNodes;
    public boolean isEnding;
    public TrieNode(char data){
        this.data = data;
        this.childNodes = new TrieNode[26];
    }
}


public class Solution {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");

        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));

        t.insert("app");
        System.out.println(t.search("app"));
    }
}