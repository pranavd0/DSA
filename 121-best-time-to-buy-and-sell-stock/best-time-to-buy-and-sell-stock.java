class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            int currprice=prices[i];
            if(currprice<min){
                min=currprice;
            }
            else{
                int profit=currprice-min;
                maxprofit=Math.max(maxprofit,profit);
            }
        }
        return maxprofit;
    }
}