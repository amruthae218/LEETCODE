class Solution {
    public int[] findNSE(int []ht)
    {
        Stack<Integer> st=new Stack<>();
        int n=ht.length;
        int [] ans=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && ht[st.peek()]>=ht[i])
            {
                st.pop();
            }
            ans[i]=(st.isEmpty())?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] findPSE(int []ht)
    {
        Stack<Integer> st=new Stack<>();
        int n=ht.length;
        int [] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && ht[st.peek()]>=ht[i])
            {
                st.pop();
            }
            ans[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nse=findNSE(heights);
        int[] pse=findPSE(heights);
        int max=0;
        int n=heights.length;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,heights[i]*(nse[i]-pse[i]-1));
        }
        return max;
    }
}