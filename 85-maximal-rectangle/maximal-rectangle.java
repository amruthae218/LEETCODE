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
    public int findMax(int[] ht)
    {
        int[]nse=findNSE(ht);
        int[]pse=findPSE(ht);
        int max=0;
        for(int i=0;i<ht.length;i++)
        {
            max=Math.max(max,ht[i]*(nse[i]-pse[i]-1));
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int[][] prefix=new int[r][c];
        int max=0;
        for(int i=0;i<c;i++)
        {
            int sum=0;
            for(int j=0;j<r;j++)
            {
                if(matrix[j][i]=='0')sum=0;
                else
                {
                    sum+=1;
                }
                prefix[j][i]=sum;
            }
        }
        for(int i=0;i<r;i++)
        {
            max=Math.max(max,findMax(prefix[i]));
        }
        return max;
    }
}