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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            TreeNode top = st.pop();
            if(prev!=null && prev.val >= top.val){
                return false;
            }
            prev = top;
            if(top.right!=null){
                curr = top.right;
            }
        }
        return true;
    }
}
