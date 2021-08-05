package arrays;
import com.sun.tools.javac.util.Pair;

public class FindMaximumSellProfit {

    /*
     * Given an array representing prices of the stock on different days,
     * find the maximum profit that can be earned by performing maximum of one transaction.
     * A transaction consists of activity of buying and selling the stock on different or same days.
     *
     * Eg: 1 - {100, 80, 120, 130, 70, 60, 100, 125}
     * the price of the stock on day-1 is 100, on day-2 is 80 and so on.
     * The maximum profit that could be earned in this window is 65 (buy at 60 and sell at 125).
     *
     * Eg: 2 - For price array - {100, 80, 70, 65, 60, 55, 50}, maximum profit that could be earned is 0.
     *
     * */
    /*
    * Explanation 
    * https://www.geeksforgeeks.org/stock-buy-sell/
    * https://www.educative.io/m/find-maximum-single-sell-profit
    * https://www.youtube.com/watch?v=YxuK6A3SvTs
    * https://www.codingninjas.com/blog/2020/09/17/a-quick-look-at-kadanes-algorithm/
    */

    public static int findMaximumProfit(int[] stockPrices) {
        int minimumPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        /*
         * The profit is the maximum value of the maximumProfit so far and
         * the difference between the current element(selling price) and the minimum buying price - i.e. profit for that buy
         * Profit = current selling price - the minimum buying price
         *
         * Minimum buying price is the minimum value between the current element and the minimum price
         * */
        for(int i=0; i<stockPrices.length; i++) {
            maxProfit = Math.max(maxProfit, stockPrices[i]-minimumPrice);
            minimumPrice = Math.min(minimumPrice, stockPrices[i]);
        }

        return maxProfit;
    }

    public static Pair<Integer, Integer> findMaximumSellProfit(int length, int[] arr) {
        int currentBuy = arr[0];
        int globalSell = arr[1];
        int globalProfit = globalSell - currentBuy;

        int currentProfit;

        for(int i=1; i< length; i++) {
            int currentSell = arr[i];
            currentProfit = currentSell - currentBuy;

            if(currentProfit > globalProfit) {
                globalProfit = currentProfit;
                globalSell = arr[i];
            }

            if(currentBuy > arr[i]) {
                currentBuy = arr[i];
            }
        }

        int optimalBuyPrice = globalSell-globalProfit;
        int optimalSellPrice = globalSell;
        return Pair.of(optimalBuyPrice, optimalSellPrice) ;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 120, 130, 70, 60, 100, 125};
        System.out.println(findMaximumSellProfit(arr.length, arr));
        System.out.println(findMaximumProfit(arr));
    }
}


/*import java.io.*;
import java.util.*;
 
class BuyStock {
 
    public static int maxProfit(int[] prices)
    {
        int n = prices.length;
        int cost = 0;
        int maxCost = 0;
 
        if (n == 0) {
            return 0;
        }
 
        // store the first element of array in a variable
 
        int min_price = prices[0];
 
        for (int i = 0; i < n; i++) {
 
            // now compare first element with all the
            // element of array and find the minimum element
 
            min_price = Math.min(min_price, prices[i]);
 
            // since min_price is smallest element of the
            // array so subtract with every element of the
            // array and return the maxCost
 
            cost = prices[i] - min_price;
 
            maxCost = Math.max(maxCost, cost);
        }
        return maxCost;
    }
   
    // Driver Code
    public static void main(String[] args)
    {
        // stock prices on consecutive days
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.print(maxProfit(prices));
    }
}*/
