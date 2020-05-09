package problem;


import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import static problem.TwoNumberSum.*;

public class TwoNumberSumTest {
    int[][] input = {
            {3, 5, -4, 8, 11, 1, -1, 6},
            {2, 7, 11, 15}};

    int[] sum = {10, 9};

    int[][] expected = {
            {11, -1},
            {2, 7}};

    @Test
    public void bruteForceTest() {
        for (int i = 0; i < input.length; i++) {
            int[] actual = bruteForce(input[i], sum[i]);
            Arrays.sort(actual);
            Arrays.sort(expected[i]);
            Assert.assertArrayEquals(expected[i], actual);
        }
    }

    @Test
    public void usingHashMapTest() {
        for (int i = 0; i < input.length; i++) {
            int[] actual = usingHashMap(input[i], sum[i]);
            Arrays.sort(actual);
            Arrays.sort(expected[i]);
            Assert.assertArrayEquals(expected[i], actual);
        }
    }

    @Test
    public void twoPointerSlidingWindowTest() {
        for (int i = 0; i < input.length; i++) {
            int[] actual = twoPointerSlidingWindow(input[i], sum[i]);
            Arrays.sort(actual);
            Arrays.sort(expected[i]);
            Assert.assertArrayEquals(expected[i], actual);
        }
    }

}