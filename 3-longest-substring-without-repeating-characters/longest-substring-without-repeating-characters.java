class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int max=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int r=0;r<s.length();r++)
        {
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.getOrDefault(s.charAt(r),0)>1)
            {
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}