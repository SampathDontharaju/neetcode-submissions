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
    public List<Integer> rightview;
    public List<Integer> rightSideView(TreeNode root) {
        rightview = new ArrayList<Integer>();
        rightSideViewHelper(root,0);
        return rightview;
    }

    private void rightSideViewHelper(TreeNode root, int level){

        if(root==null){
            return;
        }

        if(rightview.size()==level){
            rightview.add(root.val);
        }

        if(root.right!=null){
            rightSideViewHelper(root.right, level+1);
        }

        if(root.left!=null){
            rightSideViewHelper(root.left, level+1);
        }
    }
}