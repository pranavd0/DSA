class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MAX = 1024;

        boolean[][] dp = new boolean[n][MAX];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] curr = new boolean[MAX];

                if (i == 0 && j == 0) {
                    curr[grid[i][j]] = true;
                } else {
                    for (int x = 0; x < MAX; x++) {
                        if (i > 0 && dp[j][x]) {
                            curr[x ^ grid[i][j]] = true;
                        }
                        if (j > 0 && dp[j - 1][x]) {
                            curr[x ^ grid[i][j]] = true;
                        }
                    }
                }

                dp[j] = curr;
            }
        }

        for (int x = 0; x < MAX; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
