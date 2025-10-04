class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        Map<Character,Integer> map=new HashMap<>();
        int l=0;
        for(int r=0;r<s.length();r++)
        {
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c)>1)
            {
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.getOrDefault(s.charAt(l),0)==0)map.remove(s.charAt(l));
                l++;
            }
            len=Math.max(len,r-l+1);
        }
        return len;
    }
}