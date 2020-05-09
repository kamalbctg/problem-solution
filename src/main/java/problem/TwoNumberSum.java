package problem;


import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 * Write a function takes  non-empty array of distinct integers and an
 * integer representing a target sum. If any two numbers in the input array sum
 * up to the target sum, the function should return them in an array, in any
 * order. If no two numbers sum up to the target sum, the function should return
 * an empty array.
 * </p>
 * Sample-1:
 * Input: array = [3, 5, -4, 8, 11, 1, -1, 6], sum = 10
 * output: = [-1, 11]
 * Sample-2:
 * Input: array = [2, 7, 11, 15], sum = 9
 * output: = [2, 7]
 */
public class TwoNumberSum {
    // Time complexity: O(n^2)
    public static int[] bruteForce(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[]{};
    }


    // Time complexity: O(n)
    // x = sum - y;
    public static int[] usingHashMap(int[] arr, int sum) {
        HashMap<Integer, Boolean> numberMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int deference = sum - arr[i];
            if (numberMap.containsKey(deference)) {
                return new int[]{deference, arr[i]};
            }
            numberMap.put(arr[i], true);
        }
        return new int[]{};
    }

    // Time complexity: O(nlogn)
    public static int[] twoPointerSlidingWindow(int[] arr, int sum) {
        HashMap<Integer, Boolean> numberMap = new HashMap<>();
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int result = arr[left] + arr[right];
            if (result == sum) {
                return new int[]{arr[left], arr[right]};
            } else if (result < sum) {
                left++;
            } else {
                right--;
            }

        }
        return new int[]{};
    }
}
