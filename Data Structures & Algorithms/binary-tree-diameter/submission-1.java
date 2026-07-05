/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        helper(root);
        return res;
    }

    private int helper(TreeNode root){
        if(root==null ){
            return 0;
        }
        int l = 1 + helper(root.left);
        int r = 1 + helper(root.right);
        res = Math.max(l+r-2, res);// count current node twice
        return Math.max(l, r);
    }
}
