package leetcode.leetcode226;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 利用BFS广度优先遍历，翻转左右节点
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null){
                deque.add(node.left);
            }
            if(node.right != null){
                deque.add(node.right);
            }
        }
        return root;
    }
    public void middlePrint(TreeNode node){
        if(node == null) return;
        middlePrint(node.left);
        System.out.print("" + node.val + ",");
        middlePrint(node.right);
    }

/**
     4
   /   \
  2     7
 / \   / \
1   3 6   9
中序遍历：1,2,3,4,6,7,9
     4
   /   \
  7     2
 / \   / \
9   6 3   1
中序遍历：9,7,6,4,3,2,1
 */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;

        Solution s = new Solution();
        s.middlePrint(root);
        System.out.println();

        s.invertTree(root);
        s.middlePrint(root);
        System.out.println();
    }
}