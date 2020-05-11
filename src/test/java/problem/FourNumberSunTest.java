package problem;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FourNumberSunTest {
    int[][] input = {{7, 6, 4, -1, 1, 2},{1, 0, -1, 0, -2, 2}};
    int[] sum = {16,0};


    @Test
    public void test() {
        for (int i = 0; i < input.length; i++) {
            List<Integer[]> actual = FourNumberSum.usingHashMap(input[i], sum[i]);
            actual.forEach(a -> {
                System.out.println("[" + Joiner.on(",").join(a) + "]");
            });
        }
    }
}