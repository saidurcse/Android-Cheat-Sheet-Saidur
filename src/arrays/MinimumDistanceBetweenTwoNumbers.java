import java.io.*;
import java.util.*;

public class MinimumDistanceBetweenTwoNumbers {
    
    /*
	 * arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6 
	 * Output: Minimum distance between 3 and 6 is 4. 
	 * Explanation:3 is at index 0 and 6 is at index 5, 
	 * so the distance is 4
	 */

    public static int findMinimumDistance(int[] arr, int n, int x, int y) {
        int minDist = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if((x == arr[i] && y == arr[j]) ||
                        (y == arr[i] && x == arr[j]) &&
                                minDist > Math.abs(i-j)) {
                    minDist = Math.abs(i-j);
                }
            }
        }
        if (minDist > n) {
            return -1;
        }
        return minDist;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;
        System.out.println(findMinimumDistance(arr, n, x, y));
    }
}


/* Output: 4 */
