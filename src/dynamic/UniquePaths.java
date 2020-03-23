package dynamic;

/**
 * @author jianw.li
 * @date 2019/1/22 11:11 PM
 * @Description: 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    //递归方法，但是超时
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        return countRoad(m, n, 1, 1);
    }

    private static int countRoad(int m, int n, int a, int b) {
        if (m == a && n == b) {
            return 1;
        }
        int left = 0, right = 0;
        if (m > a) {
            left = countRoad(m, n, a + 1, b);
        }
        if (n > b) {
            right = countRoad(m, n, a, b + 1);
        }

        return left + right;
    }

    //动态规划
    public static int uniquePathsD(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
