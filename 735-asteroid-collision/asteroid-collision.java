class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st=new Stack<>();
        int n=asteroids.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int curr=asteroids[i];
            while(!st.isEmpty() && curr<0 && st.peek()>0)
            {
                if(st.peek()<Math.abs(curr))
                {
                    st.pop();
                }
                else if(st.peek()==Math.abs(curr))
                {
                    st.pop();
                    curr=0;
                    break;
                }
                else if(st.peek()>Math.abs(curr))
                {
                    curr=0;
                    break;
                }
            }
            if(curr!=0)st.push(curr);
        }
        int[] ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--)
        {
            ans[i]=st.peek();
            st.pop();
        }
        return ans;
    }
}