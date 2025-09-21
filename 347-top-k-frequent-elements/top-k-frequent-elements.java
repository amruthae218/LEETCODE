class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(a,b)->b.getValue()-a.getValue());
        int[] res=new int[k];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:list)
        {
            if(i<k)
            {
                res[i]=entry.getKey();
                i++;
            }
        }
        return res;
    }
}