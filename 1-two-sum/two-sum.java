class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sum=new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(sum.containsKey(target-nums[i]))
            {
                res[0]=sum.get(target-nums[i]);
                res[1]=i;
            }
            else
            {
                sum.put(nums[i],i);
            }
        }
        return res;
    }
}