class Solution {
    public void find(int i,int[] arr,int target,List<List<Integer>> res,List<Integer> curr)
    {
        if(i>=arr.length || target<=0)
        {
            if(target==0)
            {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int j=i;j<arr.length;j++)
        {
            curr.add(arr[j]);
            find(j,arr,target-arr[j],res,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        find(0,candidates,target,res,new ArrayList<>());
        return res;
    }
}