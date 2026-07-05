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
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode root){

        if(root==null){
            return;
        }

        TreeNode l = root.left;
        TreeNode r = root.right;
        //TreeNode temp = root.left;

        root.left = r;
        root.right = l;
        
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
