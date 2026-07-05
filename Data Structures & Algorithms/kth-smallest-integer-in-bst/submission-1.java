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

    public int kthsmallest;
    public int indx =0;

    public int kthSmallest(TreeNode root, int k) {
       //arr = new ArrayList<Integer>();
       inorderHelper(root, k);

       return kthsmallest;
    }

    private void inorderHelper(TreeNode root, int k){
                if(root == null){
                    return; 
                }
                inorderHelper(root.left, k);
                indx++;
                if(indx==k){
                    kthsmallest = root.val;
                    System.out.println("kthsmallest"+kthsmallest);
                    return;
                }
                inorderHelper(root.right, k);
    }
}
