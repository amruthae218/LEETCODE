class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ans=new char[s.length()];
        int l=0;
        int r=s.length()-1;
        while(l<=r)
        {
            if(Character.isAlphabetic(s.charAt(l))&&Character.isAlphabetic(s.charAt(r)))
            {
                ans[l]=s.charAt(r);
                ans[r]=s.charAt(l);
                l++;
                r--;
            }
            else
            {
                if(!Character.isAlphabetic(s.charAt(l)))
                {
                    ans[l]=s.charAt(l);
                    l++;
                }
                else if(!Character.isAlphabetic(s.charAt(r)))
                {
                    ans[r]=s.charAt(r);
                    r--;
                }
            }
        //String res=Arrays.toString(ans);
        }
        return new String(ans);


    }
}