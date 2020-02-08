package leetcode.leetcode98;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isValidBSTRecur(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node , Integer low, Integer high){
        if(node == null) return true;

        if(low != null && node.val < low) return false;
        if(high != null && node.val > high) return false;

        if(!helper(node.left, low, node.val)) return false;
        if(!helper(node.right, node.val, high)) return false;
        return true;
    }

    // 利用中序遍历，二分查找树中序遍历是有序的数组，后一个数总比前一个数大。下边利用栈模拟递归的栈操作。
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inorder = Long.MIN_VALUE;

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(20);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        Solution s = new Solution();
        boolean r = s.isValidBST(root);
        System.out.println(r);
    }
}