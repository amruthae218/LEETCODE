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
    public int balanced(TreeNode node)
    {
        if(node==null)return 0;
        int left=balanced(node.left);
        int right=balanced(node.right);
        if(left!=-1 && right!=-1 && Math.abs(left- right) <= 1)
        {
            return 1+Math.max(left,right);
        }
        else return -1;
    }
    public boolean isBalanced(TreeNode root) {
        if(balanced(root)!=-1)return true;
        return false;
    }
}