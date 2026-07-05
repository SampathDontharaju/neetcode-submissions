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

    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        //boolean result = true;
        dfsHelper(root);
        return result;
    }

    private int dfsHelper(TreeNode root){

        if(root == null) return 0;

        int left = 1 + dfsHelper(root.left);
        int right = 1 + dfsHelper(root.right);

        System.out.println("root :"+root.val+"left .."+left+"right.."+right);

        if(Math.abs(right-left)>1){
            result = false;
        } 
        return Math.max(left,right);
    }
}
