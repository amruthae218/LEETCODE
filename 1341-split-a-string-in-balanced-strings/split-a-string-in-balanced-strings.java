class Solution {
    public int balancedStringSplit(String s) {
        int total=0;
        int cntL=0;
        int cntR=0;
        for(int r=0;r<s.length();r++)
        {
            if(s.charAt(r)=='L')cntL++;
            if(s.charAt(r)=='R')cntR++;
            if(cntL==cntR)total++;
        }
        return total;
    }
}