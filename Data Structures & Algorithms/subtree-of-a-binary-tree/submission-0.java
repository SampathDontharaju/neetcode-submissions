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

    private boolean result = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {


        if(root==null && subRoot ==null){
            return true;
        }

        if(root==null || subRoot ==null)
            return false;

        inOrderHelper(root,subRoot);

        return result;

        //return  l && r;
    }

    public void inOrderHelper(TreeNode root, TreeNode subRoot){

        if(root==null){
            return;
        }

        inOrderHelper(root.left, subRoot);

        if(root.val == subRoot.val){
            boolean res = compareTrees(root, subRoot);
            System.out.println("result"+result);
            if(res){
                result = true;
                return;
            }
        }
        inOrderHelper(root.right, subRoot);
    }



     public boolean compareTrees(TreeNode p, TreeNode q){

        if(p==null && q== null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        if(p.val!=q.val){
            return false;
        }

        boolean l = compareTrees(p.left, q.left);
        boolean r = compareTrees(p.right, q.right);

        return l && r;
        
    }
}
