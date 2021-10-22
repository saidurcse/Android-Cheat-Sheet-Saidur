import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntegerSubsets {

    /*
     * Find all subsets of a given set of integers
     * Input: {2, 3, 4}
     * Output: {}, {2}, {3}, {4}, {2,3}, {2,4}, {3,4}, {2,3,4}
     *
     * Runtime Complexity:
     * Exponential, O(2n) - where 'n' is number of integers in the given set.
     *
     * Memory Complexity:
     * Exponential, O(2n)
     *
     * n = size of given integer set
     * subsets_count = 2^n
     *  for i = 0 to subsets_count
     *      form a subset using the value of 'i' as following:
     *          bits in number 'i' represent index of elements to choose from original set,
     *          if a specific bit is 1 choose that number from original set and add it to current subset,
     *  e.g. if i = 6 i.e 110 in binary means that 1st and 2nd elements in original array need to be picked.
     *  add current subset to list of all subsets
     *
     * */

    private static int getBit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    private static void getAllSubsets(List<Integer> v,
                                      List<HashSet<Integer>> sets) {

        int subsets_count = (int) (Math.pow((double) 2, (double) v.size()));
        for (int i = 0; i < subsets_count; ++i) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < v.size(); ++j) {
                if (getBit(i, j) == 1) {
                    int x = v.get(j);
                    set.add(x);
                }
            }
            sets.add(set);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8, 13, 3, 22, 17, 39, 87, 45, 36};
        List<Integer> v = new ArrayList<>();
        for (Integer i : arr) {
            v.add(i);
        }

        List<HashSet<Integer>> subsets = new ArrayList<>();
        getAllSubsets(v, subsets);

        for (int i = 0; i < subsets.size(); ++i) {
            System.out.print("{");
            for (Integer it : subsets.get(i)) {
                System.out.print(it + ", ");
            }
            System.out.println("}");
        }
    }
}


/* Output: 
{}
{8, }
{13, }
{8, 13, }
{3, }
{3, 8, }
{3, 13, }
{3, 8, 13, }
{22, }
{22, 8, }
{22, 13, }
{22, 8, 13, }
{3, 22, }
{3, 22, 8, }
{3, 22, 13, }
{3, 22, 8, 13, }
{17, }
{17, 8, }
{17, 13, }
{17, 8, 13, }
{17, 3, }
{17, 3, 8, }
{17, 3, 13, }
{17, 3, 8, 13, }
{17, 22, }
{17, 22, 8, }
{17, 22, 13, }
{17, 22, 8, 13, }
{17, 3, 22, }
{17, 3, 22, 8, }
{17, 3, 22, 13, }
{17, 3, 22, 8, 13, }
{39, }
{39, 8, }
{39, 13, }
{39, 8, 13, }
{3, 39, }
{3, 39, 8, }
{3, 39, 13, }
{3, 39, 8, 13, }
{22, 39, }
{22, 39, 8, }
{22, 39, 13, }
{22, 39, 8, 13, }
{3, 22, 39, }
{3, 22, 39, 8, }
{3, 22, 39, 13, }
{3, 22, 39, 8, 13, }
{17, 39, }
{17, 39, 8, }
{17, 39, 13, }
{17, 39, 8, 13, }
{17, 3, 39, }
{17, 3, 39, 8, }
{17, 3, 39, 13, }
{17, 3, 39, 8, 13, }
{17, 22, 39, }
{17, 22, 39, 8, }
{17, 22, 39, 13, }
{17, 22, 39, 8, 13, }
{17, 3, 22, 39, }
{17, 3, 22, 39, 8, }
{17, 3, 22, 39, 13, }
{17, 3, 22, 39, 8, 13, }
{87, }
{87, 8, }
{87, 13, }
{87, 8, 13, }
{3, 87, }
{3, 87, 8, }
{3, 87, 13, }
{3, 87, 8, 13, }
{22, 87, }
{22, 87, 8, }
{22, 87, 13, }
{22, 87, 8, 13, }
{3, 22, 87, }
{3, 22, 87, 8, }
{3, 22, 87, 13, }
{3, 22, 87, 8, 13, }
{17, 87, }
{17, 87, 8, }
{17, 87, 13, }
{17, 87, 8, 13, }
{17, 3, 87, }
{17, 3, 87, 8, }
{17, 3, 87, 13, }
{17, 3, 87, 8, 13, }
{17, 22, 87, }
{17, 22, 87, 8, }
{17, 22, 87, 13, }
{17, 22, 87, 8, 13, }
{17, 3, 22, 87, }
{17, 3, 22, 87, 8, }
{17, 3, 22, 87, 13, }
{17, 3, 22, 87, 8, 13, }
{39, 87, }
{39, 87, 8, }
{39, 87, 13, }
{39, 87, 8, 13, }
{3, 39, 87, }
{3, 39, 87, 8, }
{3, 39, 87, 13, }
{3, 39, 87, 8, 13, }
{22, 39, 87, }
{22, 39, 87, 8, }
{22, 39, 87, 13, }
{22, 39, 87, 8, 13, }
{3, 22, 39, 87, }
{3, 22, 39, 87, 8, }
{3, 22, 39, 87, 13, }
{3, 22, 39, 87, 8, 13, }
{17, 39, 87, }
{17, 39, 87, 8, }
{17, 39, 87, 13, }
{17, 39, 87, 8, 13, }
{17, 3, 39, 87, }
{17, 3, 39, 87, 8, }
{17, 3, 39, 87, 13, }
{17, 3, 39, 87, 8, 13, }
{17, 22, 39, 87, }
{17, 22, 39, 87, 8, }
{17, 22, 39, 87, 13, }
{17, 22, 39, 87, 8, 13, }
{17, 3, 22, 39, 87, }
{17, 3, 22, 39, 87, 8, }
{17, 3, 22, 39, 87, 13, }
{17, 3, 22, 39, 87, 8, 13, }
{45, }
{8, 45, }
{13, 45, }
{8, 13, 45, }
{3, 45, }
{3, 8, 45, }
{3, 13, 45, }
{3, 8, 13, 45, }
{22, 45, }
{22, 8, 45, }
{22, 13, 45, }
{22, 8, 13, 45, }
{3, 22, 45, }
{3, 22, 8, 45, }
{3, 22, 13, 45, }
{3, 22, 8, 13, 45, }
{17, 45, }
{17, 8, 45, }
{17, 13, 45, }
{17, 8, 13, 45, }
{17, 3, 45, }
{17, 3, 8, 45, }
{17, 3, 13, 45, }
{17, 3, 8, 13, 45, }
{17, 22, 45, }
{17, 22, 8, 45, }
{17, 22, 13, 45, }
{17, 22, 8, 13, 45, }
{17, 3, 22, 45, }
{17, 3, 22, 8, 45, }
{17, 3, 22, 13, 45, }
{17, 3, 22, 8, 13, 45, }
{39, 45, }
{39, 8, 45, }
{39, 13, 45, }
{39, 8, 13, 45, }
{3, 39, 45, }
{3, 39, 8, 45, }
{3, 39, 13, 45, }
{3, 39, 8, 13, 45, }
{22, 39, 45, }
{22, 39, 8, 45, }
{22, 39, 13, 45, }
{22, 39, 8, 13, 45, }
{3, 22, 39, 45, }
{3, 22, 39, 8, 45, }
{3, 22, 39, 13, 45, }
{3, 22, 39, 8, 13, 45, }
{17, 39, 45, }
{17, 39, 8, 45, }
{17, 39, 13, 45, }
{17, 39, 8, 13, 45, }
{17, 3, 39, 45, }
{17, 3, 39, 8, 45, }
{17, 3, 39, 13, 45, }
{17, 3, 39, 8, 13, 45, }
{17, 22, 39, 45, }
{17, 22, 39, 8, 45, }
{17, 22, 39, 13, 45, }
{17, 22, 39, 8, 13, 45, }
{17, 3, 22, 39, 45, }
{17, 3, 22, 39, 8, 45, }
{17, 3, 22, 39, 13, 45, }
{17, 3, 22, 39, 8, 13, 45, }
{87, 45, }
{87, 8, 45, }
{87, 13, 45, }
{87, 8, 13, 45, }
{3, 87, 45, }
{3, 87, 8, 45, }
{3, 87, 13, 45, }
{3, 87, 8, 13, 45, }
{22, 87, 45, }
{22, 87, 8, 45, }
{22, 87, 13, 45, }
{22, 87, 8, 13, 45, }
{3, 22, 87, 45, }
{3, 22, 87, 8, 45, }
{3, 22, 87, 13, 45, }
{3, 22, 87, 8, 13, 45, }
{17, 87, 45, }
{17, 87, 8, 45, }
{17, 87, 13, 45, }
{17, 87, 8, 13, 45, }
{17, 3, 87, 45, }
{17, 3, 87, 8, 45, }
{17, 3, 87, 13, 45, }
{17, 3, 87, 8, 13, 45, }
{17, 22, 87, 45, }
{17, 22, 87, 8, 45, }
{17, 22, 87, 13, 45, }
{17, 22, 87, 8, 13, 45, }
{17, 3, 22, 87, 45, }
{17, 3, 22, 87, 8, 45, }
{17, 3, 22, 87, 13, 45, }
{17, 3, 22, 87, 8, 13, 45, }
{39, 87, 45, }
{39, 87, 8, 45, }
{39, 87, 13, 45, }
{39, 87, 8, 13, 45, }
{3, 39, 87, 45, }
{3, 39, 87, 8, 45, }
{3, 39, 87, 13, 45, }
{3, 39, 87, 8, 13, 45, }
{22, 39, 87, 45, }
{22, 39, 87, 8, 45, }
{22, 39, 87, 13, 45, }
{22, 39, 87, 8, 13, 45, }
{3, 22, 39, 87, 45, }
{3, 22, 39, 87, 8, 45, }
{3, 22, 39, 87, 13, 45, }
{3, 22, 39, 87, 8, 13, 45, }
{17, 39, 87, 45, }
{17, 39, 87, 8, 45, }
{17, 39, 87, 13, 45, }
{17, 39, 87, 8, 13, 45, }
{17, 3, 39, 87, 45, }
{17, 3, 39, 87, 8, 45, }
{17, 3, 39, 87, 13, 45, }
{17, 3, 39, 87, 8, 13, 45, }
{17, 22, 39, 87, 45, }
{17, 22, 39, 87, 8, 45, }
{17, 22, 39, 87, 13, 45, }
{17, 22, 39, 87, 8, 13, 45, }
{17, 3, 22, 39, 87, 45, }
{17, 3, 22, 39, 87, 8, 45, }
{17, 3, 22, 39, 87, 13, 45, }
{17, 3, 22, 39, 87, 8, 13, 45, }
{36, }
{36, 8, }
{36, 13, }
{36, 8, 13, }
{3, 36, }
{3, 36, 8, }
{3, 36, 13, }
{3, 36, 8, 13, }
{36, 22, }
{36, 22, 8, }
{36, 22, 13, }
{36, 22, 8, 13, }
{3, 36, 22, }
{3, 36, 22, 8, }
{3, 36, 22, 13, }
{3, 36, 22, 8, 13, }
{17, 36, }
{17, 36, 8, }
{17, 36, 13, }
{17, 36, 8, 13, }
{17, 3, 36, }
{17, 3, 36, 8, }
{17, 3, 36, 13, }
{17, 3, 36, 8, 13, }
{17, 36, 22, }
{17, 36, 22, 8, }
{17, 36, 22, 13, }
{17, 36, 22, 8, 13, }
{17, 3, 36, 22, }
{17, 3, 36, 22, 8, }
{17, 3, 36, 22, 13, }
{17, 3, 36, 22, 8, 13, }
{36, 39, }
{36, 39, 8, }
{36, 39, 13, }
{36, 39, 8, 13, }
{3, 36, 39, }
{3, 36, 39, 8, }
{3, 36, 39, 13, }
{3, 36, 39, 8, 13, }
{36, 22, 39, }
{36, 22, 39, 8, }
{36, 22, 39, 13, }
{36, 22, 39, 8, 13, }
{3, 36, 22, 39, }
{3, 36, 22, 39, 8, }
{3, 36, 22, 39, 13, }
{3, 36, 22, 39, 8, 13, }
{17, 36, 39, }
{17, 36, 39, 8, }
{17, 36, 39, 13, }
{17, 36, 39, 8, 13, }
{17, 3, 36, 39, }
{17, 3, 36, 39, 8, }
{17, 3, 36, 39, 13, }
{17, 3, 36, 39, 8, 13, }
{17, 36, 22, 39, }
{17, 36, 22, 39, 8, }
{17, 36, 22, 39, 13, }
{17, 36, 22, 39, 8, 13, }
{17, 3, 36, 22, 39, }
{17, 3, 36, 22, 39, 8, }
{17, 3, 36, 22, 39, 13, }
{17, 3, 36, 22, 39, 8, 13, }
{36, 87, }
{36, 87, 8, }
{36, 87, 13, }
{36, 87, 8, 13, }
{3, 36, 87, }
{3, 36, 87, 8, }
{3, 36, 87, 13, }
{3, 36, 87, 8, 13, }
{36, 22, 87, }
{36, 22, 87, 8, }
{36, 22, 87, 13, }
{36, 22, 87, 8, 13, }
{3, 36, 22, 87, }
{3, 36, 22, 87, 8, }
{3, 36, 22, 87, 13, }
{3, 36, 22, 87, 8, 13, }
{17, 36, 87, }
{17, 36, 87, 8, }
{17, 36, 87, 13, }
{17, 36, 87, 8, 13, }
{17, 3, 36, 87, }
{17, 3, 36, 87, 8, }
{17, 3, 36, 87, 13, }
{17, 3, 36, 87, 8, 13, }
{17, 36, 22, 87, }
{17, 36, 22, 87, 8, }
{17, 36, 22, 87, 13, }
{17, 36, 22, 87, 8, 13, }
{17, 3, 36, 22, 87, }
{17, 3, 36, 22, 87, 8, }
{17, 3, 36, 22, 87, 13, }
{17, 3, 36, 22, 87, 8, 13, }
{36, 39, 87, }
{36, 39, 87, 8, }
{36, 39, 87, 13, }
{36, 39, 87, 8, 13, }
{3, 36, 39, 87, }
{3, 36, 39, 87, 8, }
{3, 36, 39, 87, 13, }
{3, 36, 39, 87, 8, 13, }
{36, 22, 39, 87, }
{36, 22, 39, 87, 8, }
{36, 22, 39, 87, 13, }
{36, 22, 39, 87, 8, 13, }
{3, 36, 22, 39, 87, }
{3, 36, 22, 39, 87, 8, }
{3, 36, 22, 39, 87, 13, }
{3, 36, 22, 39, 87, 8, 13, }
{17, 36, 39, 87, }
{17, 36, 39, 87, 8, }
{17, 36, 39, 87, 13, }
{17, 36, 39, 87, 8, 13, }
{17, 3, 36, 39, 87, }
{17, 3, 36, 39, 87, 8, }
{17, 3, 36, 39, 87, 13, }
{17, 3, 36, 39, 87, 8, 13, }
{17, 36, 22, 39, 87, }
{17, 36, 22, 39, 87, 8, }
{17, 36, 22, 39, 87, 13, }
{17, 36, 22, 39, 87, 8, 13, }
{17, 3, 36, 22, 39, 87, }
{17, 3, 36, 22, 39, 87, 8, }
{17, 3, 36, 22, 39, 87, 13, }
{17, 3, 36, 22, 39, 87, 8, 13, }
{36, 45, }
{36, 8, 45, }
{36, 13, 45, }
{36, 8, 13, 45, }
{3, 36, 45, }
{3, 36, 8, 45, }
{3, 36, 13, 45, }
{3, 36, 8, 13, 45, }
{36, 22, 45, }
{36, 22, 8, 45, }
{36, 22, 13, 45, }
{36, 22, 8, 13, 45, }
{3, 36, 22, 45, }
{3, 36, 22, 8, 45, }
{3, 36, 22, 13, 45, }
{3, 36, 22, 8, 13, 45, }
{17, 36, 45, }
{17, 36, 8, 45, }
{17, 36, 13, 45, }
{17, 36, 8, 13, 45, }
{17, 3, 36, 45, }
{17, 3, 36, 8, 45, }
{17, 3, 36, 13, 45, }
{17, 3, 36, 8, 13, 45, }
{17, 36, 22, 45, }
{17, 36, 22, 8, 45, }
{17, 36, 22, 13, 45, }
{17, 36, 22, 8, 13, 45, }
{17, 3, 36, 22, 45, }
{17, 3, 36, 22, 8, 45, }
{17, 3, 36, 22, 13, 45, }
{17, 3, 36, 22, 8, 13, 45, }
{36, 39, 45, }
{36, 39, 8, 45, }
{36, 39, 13, 45, }
{36, 39, 8, 13, 45, }
{3, 36, 39, 45, }
{3, 36, 39, 8, 45, }
{3, 36, 39, 13, 45, }
{3, 36, 39, 8, 13, 45, }
{36, 22, 39, 45, }
{36, 22, 39, 8, 45, }
{36, 22, 39, 13, 45, }
{36, 22, 39, 8, 13, 45, }
{3, 36, 22, 39, 45, }
{3, 36, 22, 39, 8, 45, }
{3, 36, 22, 39, 13, 45, }
{3, 36, 22, 39, 8, 13, 45, }
{17, 36, 39, 45, }
{17, 36, 39, 8, 45, }
{17, 36, 39, 13, 45, }
{17, 36, 39, 8, 13, 45, }
{17, 3, 36, 39, 45, }
{17, 3, 36, 39, 8, 45, }
{17, 3, 36, 39, 13, 45, }
{17, 3, 36, 39, 8, 13, 45, }
{17, 36, 22, 39, 45, }
{17, 36, 22, 39, 8, 45, }
{17, 36, 22, 39, 13, 45, }
{17, 36, 22, 39, 8, 13, 45, }
{17, 3, 36, 22, 39, 45, }
{17, 3, 36, 22, 39, 8, 45, }
{17, 3, 36, 22, 39, 13, 45, }
{17, 3, 36, 22, 39, 8, 13, 45, }
{36, 87, 45, }
{36, 87, 8, 45, }
{36, 87, 13, 45, }
{36, 87, 8, 13, 45, }
{3, 36, 87, 45, }
{3, 36, 87, 8, 45, }
{3, 36, 87, 13, 45, }
{3, 36, 87, 8, 13, 45, }
{36, 22, 87, 45, }
{36, 22, 87, 8, 45, }
{36, 22, 87, 13, 45, }
{36, 22, 87, 8, 13, 45, }
{3, 36, 22, 87, 45, }
{3, 36, 22, 87, 8, 45, }
{3, 36, 22, 87, 13, 45, }
{3, 36, 22, 87, 8, 13, 45, }
{17, 36, 87, 45, }
{17, 36, 87, 8, 45, }
{17, 36, 87, 13, 45, }
{17, 36, 87, 8, 13, 45, }
{17, 3, 36, 87, 45, }
{17, 3, 36, 87, 8, 45, }
{17, 3, 36, 87, 13, 45, }
{17, 3, 36, 87, 8, 13, 45, }
{17, 36, 22, 87, 45, }
{17, 36, 22, 87, 8, 45, }
{17, 36, 22, 87, 13, 45, }
{17, 36, 22, 87, 8, 13, 45, }
{17, 3, 36, 22, 87, 45, }
{17, 3, 36, 22, 87, 8, 45, }
{17, 3, 36, 22, 87, 13, 45, }
{17, 3, 36, 22, 87, 8, 13, 45, }
{36, 39, 87, 45, }
{36, 39, 87, 8, 45, }
{36, 39, 87, 13, 45, }
{36, 39, 87, 8, 13, 45, }
{3, 36, 39, 87, 45, }
{3, 36, 39, 87, 8, 45, }
{3, 36, 39, 87, 13, 45, }
{3, 36, 39, 87, 8, 13, 45, }
{36, 22, 39, 87, 45, }
{36, 22, 39, 87, 8, 45, }
{36, 22, 39, 87, 13, 45, }
{36, 22, 39, 87, 8, 13, 45, }
{3, 36, 22, 39, 87, 45, }
{3, 36, 22, 39, 87, 8, 45, }
{3, 36, 22, 39, 87, 13, 45, }
{3, 36, 22, 39, 87, 8, 13, 45, }
{17, 36, 39, 87, 45, }
{17, 36, 39, 87, 8, 45, }
{17, 36, 39, 87, 13, 45, }
{17, 36, 39, 87, 8, 13, 45, }
{17, 3, 36, 39, 87, 45, }
{17, 3, 36, 39, 87, 8, 45, }
{17, 3, 36, 39, 87, 13, 45, }
{17, 3, 36, 39, 87, 8, 13, 45, }
{17, 36, 22, 39, 87, 45, }
{17, 36, 22, 39, 87, 8, 45, }
{17, 36, 22, 39, 87, 13, 45, }
{17, 36, 22, 39, 87, 8, 13, 45, }
{17, 3, 36, 22, 39, 87, 45, }
{17, 3, 36, 22, 39, 87, 8, 45, }
{17, 3, 36, 22, 39, 87, 13, 45, }
{17, 3, 36, 22, 39, 87, 8, 13, 45, } 
*/
