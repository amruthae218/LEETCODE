class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        int n=num.length();
        for(int i=0;i<n;i++)
        {
            while(k>0 && !st.isEmpty() && st.peek()>Character.getNumericValue(num.charAt(i)))
            {
                st.pop();
                k--;
            }
            st.push(Character.getNumericValue(num.charAt(i)));
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            ans.append(st.get(i));
        }

        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}