class Solution {
    public void swap(int[] nums,int l,int r)
    {
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(nums,mid,low);
                mid++;low++;
            }
            else if(nums[mid]==1)mid++;
            else if(nums[mid]==2)
            {
                swap(nums,mid,high);
                high--;
            }
        }
        
    }
}