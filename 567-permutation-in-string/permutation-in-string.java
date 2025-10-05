class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())return false;
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s1.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s1.length();i++)
        {
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)-1);
            if(map.getOrDefault(s2.charAt(i),0)==0)map.remove(s2.charAt(i));
        }
        if(map.size()==0)return true;
        for(int i=s1.length();i<s2.length();i++)
        {
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)-1);
            if(map.getOrDefault(s2.charAt(i),0)==0)map.remove(s2.charAt(i));
            char left = s2.charAt(i - s1.length());
            map.put(left, map.getOrDefault(left, 0) + 1);
            if (map.getOrDefault(left, 0) == 0) map.remove(left);
            if(map.size()==0)return true;
        }
        return false;
    }
}