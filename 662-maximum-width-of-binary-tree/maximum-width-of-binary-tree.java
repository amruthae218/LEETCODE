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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Long> map=new HashMap<>();
        q.offer(root);
        map.put(root,0L);
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            int size=q.size();
            long left=Long.MAX_VALUE;
            long right=Long.MIN_VALUE;
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                long idx=map.get(node);
                left=Math.min(left,idx);
                right=Math.max(right,idx);
                if(node.left!=null)
                {
                    q.offer(node.left);
                    map.put(node.left,2*idx);
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                    map.put(node.right,2*idx+1);
                }
            }
            max=Math.max(max,(int)(right-left+1));
        }
        return max;
    }
}