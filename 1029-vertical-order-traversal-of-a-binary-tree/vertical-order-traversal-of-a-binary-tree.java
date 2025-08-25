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
class Node
{
    TreeNode node;
    int row;
    int col;
    Node(TreeNode node,int col,int row)
    {
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(root,0,0));
        if(!map.containsKey(0))
        {
            map.put(0,new TreeMap<>());
        }
        if(!map.get(0).containsKey(0))
        {
            map.get(0).put(0,new ArrayList<>());
        }
        map.get(0).get(0).add(root.val);
        while(!q.isEmpty())
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                Node n=q.poll();
                TreeNode node=n.node;
                int row=n.row;
                int col=n.col;

                if(node.left!=null)
                {
                    if(!map.containsKey(col-1))
                    {
                        map.put(col-1,new TreeMap<>());
                    }
                    if(!map.get(col-1).containsKey(row+1))
                    {
                        map.get(col-1).put(row+1,new ArrayList<>());
                    }
                    map.get(col-1).get(row+1).add(node.left.val);
                    q.offer(new Node(node.left,col-1,row+1));
                }
                if(node.right!=null)
                {
                    if(!map.containsKey(col+1))
                    {
                        map.put(col+1,new TreeMap<>());
                    }
                    if(!map.get(col+1).containsKey(row+1))
                    {
                        map.get(col+1).put(row+1,new ArrayList<>());
                    }
                    map.get(col+1).get(row+1).add(node.right.val);
                    q.offer(new Node(node.right,col+1,row+1));
                }
            }
        }
        List<List<Integer>>res=new ArrayList<>();
        for(int col:map.keySet())
        {
            List<Integer> colList=new ArrayList<>();
            for(int row:map.get(col).keySet())
            {
                List<Integer> values = map.get(col).get(row);
                Collections.sort(values);
                colList.addAll(values);
            }
            res.add(colList);
        }
        return res;
    }
}