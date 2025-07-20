class Solution {
    public int[] findNSE(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] nse=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findPSE(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] pse=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nse=findNSE(arr);
        int[] pse=findPSE(arr);
        long total=0;
        int MOD=(int)1e9+7;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int right=nse[i]-i;
            int left=i-pse[i];
            long contrib = ((long) left * right % MOD) * arr[i] % MOD;
            total = (total + contrib) % MOD;
        }
        return (int)total;
    }
}