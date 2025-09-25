class Solution {
    public boolean isPalindrome(String s) {
        int r=s.length()-1;
        int l=0;
        while(l<=r)
        {
            char left=Character.toLowerCase(s.charAt(l));
            char right=Character.toLowerCase(s.charAt(r));
            if(Character.isLetterOrDigit(left) && Character.isLetterOrDigit(right))
            {
                if(left==right)
                {
                    l++;r--;
                }
                else return false;
            }
            else 
            {
                if(!Character.isLetterOrDigit(left))l++;
                if(!Character.isLetterOrDigit(right))r--;
            }
        }
        return true;
    }
}