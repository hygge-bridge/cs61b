package Disc03;

import static org.junit.Assert.*;
import org.junit.Test;

public class FullGridTest {
    @Test
    public void testFillGrid() {
        // 1. 准备输入数据
        int[] LL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0};
        int[] UR = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[][] S = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        // 2. 调用待测方法
        FullGrid.fillGrid(LL, UR, S);

        // 3. 准备期望的结果（根据图片上的要求）
        int[][] expected = {
                {0, 11, 12, 13, 14},
                {1, 0, 15, 16, 17},
                {2, 3, 0, 18, 19},
                {4, 5, 6, 0, 20},
                {7, 8, 9, 10, 0}
        };

        // 4. 断言验证（逐元素对比）
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S[i].length; j++) {
                assertEquals(expected[i][j], S[i][j]);
            }
        }
    }
}