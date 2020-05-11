package problem.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * Write a function that takes in a non-empty array of distinct integers and an
 * integer representing a target sum. The function should find all quadruplets in
 * the array that sum up to the target sum and return a two-dimensional array of
 * all these quadruplets in no particular order.
 * If no four numbers sum up to the target sum, the function should return an
 * empty array.
 * </p>
 * Sample-1:
 * Input: array  = [7, 6, 4, -1, 1, 2], sum = 16
 * output: = [[7, 6, 4, -1], [7, 6, 1, 2]]
 * Sample-1:
 * Input: array  = [1, 0, -1, 0, -2, 2], sum = 0
 * output: = [[-1,  0, 0, 1], [-2, -1, 1, 2], [-2,  0, 0, 2]]
 */
public class FourNumberSum {
    // Time complexity: O(n^2), Space: O(n^n)
    public static List<Integer[]> usingHashMap(int[] arr, int sum) {
        HashMap<Integer, List<Integer[]>> allPairs = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = sum - (arr[i] + arr[j]);
                if (allPairs.containsKey(diff)) {
                    for (Integer[] pair : allPairs.get(diff)) {
                        quadruplets.add(new Integer[]{pair[0], pair[1], arr[i], arr[j]});
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int tmp = arr[k] + arr[i];
                Integer[] pair = new Integer[]{arr[k], arr[i]};
                List<Integer[]> pairs = new ArrayList<>();
                pairs.add(pair);
                if (allPairs.containsKey(tmp)) {
                    allPairs.get(tmp).add(pair);
                } else {
                    allPairs.put(tmp, pairs);
                }
            }
        }
        return quadruplets;
    }
}
