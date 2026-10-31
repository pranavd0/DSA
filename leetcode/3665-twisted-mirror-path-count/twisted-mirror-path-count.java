class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        final int MOD = 1_000_000_007;

        // dp[j][0] = paths entering from top
        // dp[j][1] = paths entering from left
        int[][] dp = new int[n][2];

        // Starting cell
        dp[0][0] = 1;

        // Initialize first row
        for (int j = 1; j < n; j++) {
            dp[j][1] = 1;

            if (grid[0][j] == 1) {
                break;
            }
        }

        for (int i = 1; i < m; i++) {

            int[][] next = new int[n][2];

            // First column
            next[0][0] = (grid[i - 1][0] == 1)
                    ? 0 : dp[0][0];

            for (int j = 1; j < n; j++) {

                // Entering from top
                next[j][0] = (
                    grid[i - 1][j] == 1
                    ? dp[j][1]
                    : (dp[j][0] + dp[j][1]) % MOD
                );

                // Entering from left
                next[j][1] = (
                    grid[i][j - 1] == 1
                    ? next[j - 1][0]
                    : (next[j - 1][0] + next[j - 1][1]) % MOD
                );
            }

            dp = next;
        }

        return (dp[n - 1][0] + dp[n - 1][1]) % MOD;
    }
}
