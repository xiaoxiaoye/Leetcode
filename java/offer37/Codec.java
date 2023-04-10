package leetcode.offer37;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                builder.append("null").append(",");
            } else {
                builder.append(node.val).append(",");
            }
            if (node != null){
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return builder.substring(0, builder.length() - 1).toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] strNodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strNodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(strNodes[i])) {
                node.left = new TreeNode(Integer.parseInt(strNodes[i]));
                queue.add(node.left);
            }
            i++;
            if (!"null".equals(strNodes[i])) {
                node.right = new TreeNode(Integer.parseInt(strNodes[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Codec s = new Codec();
        String r = s.serialize(node1);
        System.out.println(r);


        TreeNode r2 = s.deserialize(r);
        System.out.println(r2);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));