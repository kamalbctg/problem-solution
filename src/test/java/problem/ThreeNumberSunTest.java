package problem;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeNumberSunTest {
    int[][] input = {
            {12, 3, 1, 2, -6, 5, -8, 6}};

    int[] sum = {0};

    List<Integer[]> expected = new ArrayList<>();

    {
        expected.add(new Integer[]{-8, 2, 6});
        expected.add(new Integer[]{-8, 3, 5});
        expected.add(new Integer[]{-6, 1, 5});
    }

    @Test
    public void testBruteForce() {
        for (int i = 0; i < input.length; i++) {
            List<Integer[]> actual = ThreeNumberSum.bruteForce(input[i], sum[i]);
            actual.forEach(a -> {
                System.out.println("[" + Joiner.on(",").join(a) + "]");
            });
        }
    }

    @Test
    public void twoPointerSlidingWindow() {
        for (int i = 0; i < input.length; i++) {
            List<Integer[]> actual = ThreeNumberSum.twoPointerSlidingWindow(input[i], sum[i]);
            actual.forEach(a -> {
                System.out.println("[" + Joiner.on(",").join(a) + "]");
            });
        }
    }
}