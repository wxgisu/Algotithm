 class ZeroOneKnapsack {
     public static void main(String[] args) {
         ZeroOneKnapsack ks = new ZeroOneKnapsack();
         int[] profits = {31, 26, 72, 17};
         int[] weights = {3, 1, 5, 2};
         int capacity = 7;
         int res = ks.maxProfit(profits, weights, capacity);
         System.out.println(res);

     }

     public int maxProfit(int[] profits, int[] weights, int capacity) {
         if (profits.length == 0 || profits == null) return 0;
         return maxProfit(profits, weights, capacity, 0);
     }

     private int maxProfit(int[] profits, int[] weights, int capacity, int curIndex) {
         //base case
         if (capacity <= 0 || curIndex == profits.length) return 0;

         //recursion
         //case1: take the item if capacity allows
         int profitTake = 0;
         if (weights[curIndex] <= capacity)
            profitTake = profits[curIndex] + maxProfit(profits, weights, capacity - weights[curIndex], curIndex + 1);
        //case2: don't take the item
        int profitNotTake = maxProfit(profits, weights, capacity, curIndex + 1);

        return Math.max(profitTake, profitNotTake);
     }
 }