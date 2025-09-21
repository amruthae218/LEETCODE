class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<char[]> charArr=new ArrayList<>();

        for(int i=0;i<strs.length;i++)
        {
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr); 
            charArr.add(arr);
        }
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<charArr.size();i++)
        {
            String s=new String(charArr.get(i));
            map.putIfAbsent(s,map.getOrDefault(s,new ArrayList<>()));
            map.get(s).add(strs[i]);
        }
        List<List<String>> res=new ArrayList<>();
        for(String s1:map.keySet())
        {
            res.add(map.get(s1));
        }
        return res;
    }
}