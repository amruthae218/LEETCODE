class Solution {
    public int maxProfit(int[] prices) {
        int price=Integer.MAX_VALUE;
        int profit=0;
        for(int p:prices)
        {
            if(p<price)
            {
                price=p;
            }
            else
            {
                profit=Math.max(profit,p-price);
            }
        }
        return profit;
    }
}