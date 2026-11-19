package Disc03;

public class FullGrid {
    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int kL, kR;
        kL = kR = 0;

        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                if (j < i) {
                    S[i][j] = LL[kL];
                    kL += 1;
                } else if (j > i) {
                    S[i][j] = UR[kR];
                    kR += 1;
                }
            }
        }
    }
}