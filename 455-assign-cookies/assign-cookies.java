class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0;
        int l=0;int r=0;
        while(r<g.length && l<s.length)
        {
            if(s[l]>=g[r])
            {
                cnt++;
                r++;
                l++;
            }
            else
            {
                l++;
            }
        }
        return cnt;
    }
}