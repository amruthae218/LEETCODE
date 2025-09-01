class Solution {
    public boolean checkPalindrom(String s)
    {
        int l=0;
        int r=s.length()-1;
        while(l<=r)
        {
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
    public void find(int i,String s,List<List<String>> res,List<String> curr)
    {
        if(i>=s.length())
        {
            res.add(new ArrayList<>(curr));
        }
        for(int j=i;j<s.length();j++)
        {
            String sub = s.substring(i, j+1);
            if (checkPalindrom(sub)) {
                curr.add(sub);
                find(j+1, s, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        find(0,s,res,new ArrayList<>());
        return res;
    }
}