class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int total = 0;
        int n = height.length;

        for(int right=0;right<n;right++)
        {
            while(!st.isEmpty() && height[right]>height[st.peek()])
            {
                int bottom=st.pop();
                if(st.isEmpty())continue;
                int left=st.peek();
                int width=right-left-1;
                int ht=Math.min(height[left],height[right])-height[bottom];
                total+=width*ht;
            }
            st.push(right);
        }

        return total;
    }
}