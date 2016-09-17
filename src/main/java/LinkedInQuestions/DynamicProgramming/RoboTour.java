package LinkedInQuestions.DynamicProgramming;

/**
 * Created by rmukherj on 8/22/16.
 */
public class RoboTour {
    private int backtrack(int r, int c, int m, int n) {
        if (r == m - 1 && c == n - 1)
            return 1;
        if (r >= m || c >= n)
            return 0;
        return backtrack(r + 1, c, m, n) + backtrack(r, c + 1, m, n);
    }
    public int uniquePaths(int m, int n) {
        return backtrack(0, 0, m, n);
    }

    // DP way
    private int backtrack(int r, int c, int m, int n, int[][] mat) {
        if (r == m - 1 && c == n - 1)
            return 1;
        if (r >= m || c >= n)
            return 0;
        if (mat[r + 1][c] == -1)
            mat[r + 1][c] = backtrack(r + 1, c, m, n, mat);
        if (mat[r][c+1] == -1)
            mat[r][c + 1] = backtrack(r, c + 1, m, n, mat);
        return mat[r + 1][c] + mat[r][c + 1];
    }
    public int uniquePathsDp(int m, int n) {
        int[][] mat = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                mat[i][j] = -1;
            }
        }
        return backtrack(0, 0, m, n, mat);
    }
}
