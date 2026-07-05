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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfsHelper(root, 0, res);

        for(int i=0; i<res.size(); i++){
            int size = res.get(i).size();
            result.add(res.get(i).get(size-1));
        }
        return result;
    }


    private void dfsHelper(TreeNode root, int level, List<List<Integer>> res){
        if(root==null) return;

        if(level == res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);

        dfsHelper(root.left, level+1, res);
        dfsHelper(root.right, level+1, res);
    }
}
