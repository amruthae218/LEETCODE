class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                idx=i;
                break;
            }
        }
        if(idx!=-1)
        {
            for(int i=n-1;i>idx;i--)
            {
                if(nums[i]>nums[idx])
                {
                    swap(nums,i,idx);
                    break;
                }
            }
        }
        
        reverse (nums,idx+1,n-1);
    }
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums,int l,int r)
    {
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
        
    }
}