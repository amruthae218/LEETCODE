class Solution {
    public void find(int i,int[]nums,List<List<Integer>> res,List<Integer> curr)
    {
        res.add(new ArrayList<>(curr));
        
        for(int j=i;j<nums.length;j++)
        {
            if(j>i && nums[j-1]==nums[j])continue;
            curr.add(nums[j]);
            find(j+1,nums,res,curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        find(0,nums,res,new ArrayList<>());
        return res;
    }
}