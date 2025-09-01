class Solution {
    public void find(int i,int[]nums,int target,List<List<Integer>> res,List<Integer> curr)
    {
        if(i>=nums.length || target<=0)
        {
            if(target==0)res.add(new ArrayList<>(curr));
            return;
        }
        for(int j=i;j<nums.length;j++)
        {
            if(j>i && nums[j]==nums[j-1])continue;
            curr.add(nums[j]);
            find(j+1,nums,target-nums[j],res,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        find(0,candidates,target,res,new ArrayList<>());
        return res;
    }
}