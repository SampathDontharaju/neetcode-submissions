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

    public TreeNode pre = null;
    public boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        
        inorderHelper(root);

        return isValid;
    }

    public void inorderHelper(TreeNode root){

        if(root==null){
            return;
        }
        inorderHelper(root.left);
        if(pre!=null && pre.val >= root.val){
            isValid = false;
            return;
        }
        pre = root;
        inorderHelper(root.right);
    }
}
