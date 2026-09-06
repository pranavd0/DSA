class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] ans = new int[rows * cols];
        int index = 0;

        // Total number of diagonals
        for (int d = 0; d < rows + cols - 1; d++) {

            // Find starting position of this diagonal
            int row;
            int col;

            if (d < cols) {
                // Diagonal starts from top row
                row = 0;
                col = d;
            } else {
                // Diagonal starts from last column
                row = d - cols + 1;
                col = cols - 1;
            }

            // Store the current diagonal in a temporary array
            int[] temp = new int[Math.min(rows, cols)];

            int count = 0;

            while (row < rows && col >= 0) {
                temp[count++] = mat[row][col];

                row++;
                col--;
            }

            // Even diagonal -> reverse the collected elements
            if (d % 2 == 0) {
                for (int i = count - 1; i >= 0; i--) {
                    ans[index++] = temp[i];
                }
            }
            // Odd diagonal -> keep the collected order
            else {
                for (int i = 0; i < count; i++) {
                    ans[index++] = temp[i];
                }
            }
        }

        return ans;
    }
}