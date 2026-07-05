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
    int kthsmallest ;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = root;
        //st.push(curr);
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            TreeNode t = st.pop();
            System.out.println("t .."+t.val);
            k--;
            if(k==0){
                return t.val;
            }

            if(t.right!=null){
                curr = t.right;
            }
        }
        return -1;
    }

    // private void inOrderHelper(TreeNode root){

    //     if(root==null || k==0){
    //         return;
    //     }
    //     inOrderHelper(root.left);
    //     this.k--;
    //     //System.out.println("k"+k +"root val "+root.val);
    //     if(this.k==0){
    //         //System.out.println("kth smallest"+root.val);
    //         kthsmallest = root.val;
    //         return;
    //     }
    //     inOrderHelper(root.right);
    // }
}
