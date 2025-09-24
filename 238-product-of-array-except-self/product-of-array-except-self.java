class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pfx=new int[nums.length];
        int[] sfx=new int[nums.length];
        int[] res=new int[nums.length];
        int pdt=1;
        for(int i=0;i<nums.length;i++)
        {
            pfx[i]=pdt;
            pdt*=nums[i];

        }
        pdt=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            sfx[i]=pdt;
            pdt*=nums[i];

        }
        for(int i=0;i<nums.length;i++)
        {
            res[i]=pfx[i]*sfx[i];
        }
        return res;
    }
}