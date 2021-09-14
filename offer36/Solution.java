package leetcode.offer36;

import java.util.Arrays;
import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        LinkedList<Node> list = new LinkedList<>();
        dfs(root, list);

        Node dummy = new Node(-1);
        Node tail = dummy;
        for(Node node: list){
            node.right = tail.right;
            tail.right = node;

            node.left = tail;
            tail = tail.right;
        }
        return dummy.right;
    }

    private void dfs(Node root, LinkedList<Node> list){
        if(root == null) return;

        dfs(root.left, list);
        list.addLast(root);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        String s = Arrays.toString(new Integer[]{1,2,null, 3});
        System.out.println(s);
    }
}