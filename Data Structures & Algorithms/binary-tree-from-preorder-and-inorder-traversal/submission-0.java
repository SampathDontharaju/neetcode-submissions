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

    Map<Integer,Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = helper(0, preorder.length-1, preorder, 0, inorder.length-1, inorder, inMap);
        return root;
    }

    private TreeNode helper(int preStart, int preEnd, int[] preorder,
                             int inStart, int inEnd, int[] inorder, Map<Integer,Integer> inMap){
        

        if(preStart > preEnd || inStart>inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = inMap.get(root.val);
        int numsLeft = inIndex-inStart;

        root.left = helper(preStart+1, preStart+numsLeft , preorder, inStart, inIndex-1, inorder, inMap);

        root.right = helper(preStart+numsLeft+1, preEnd, preorder, inIndex+1, inEnd,inorder, inMap);

        return root;
    }







}
