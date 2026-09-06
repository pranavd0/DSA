import java.util.ArrayList;
import java.util.List;

public class TwoDimensionArray_Questions {

    List<Integer> gDiagonaltraversal(int[][] x){
        List<Integer> result = new ArrayList<>();
        // we will follow patterns first we will traverse diagonals ending to the first row
        //afterwards we will traverse diagonals ending on th last column
        //we will just skip the (0,last column) element as it is done in first traversal
        //hence we will start second loop from 1
        // as the first loop iterate on columns we uses i and matrix[0].length(no. of coloumns) 
        for(int i=0;i<x[0].length;i++){
            /*for each diagonal
            *example digaonal at index 2-
            *elemnts are
            * 0,2
            * 1,1
            * 2,0
            * hence i increaes j decreses where jstarts from column no.(diagonal no.)
            */ 
            int l=i;
            int r=0;
            
            while(r<=i&&l>=0){
                result.add(x[l][r]);
                l--;
                r++;
            }
        }
        //now for diagonal ending on last column 
        //we will iterate on j i.e rows starting from 1 as 0 is already done 
        for(int j=1;j<x.length;j++){
            //our l means(i) will always start from last row 
            //consider is at like we are doing same procedure from the downward side of matrix
            //and from right most column 
            //here lis our i(row no) and k is j(column no)
            //k will start from j-1 to ensure increment in our row in each iteration of our for loop 
            //i.e column increment
            int l=x.length-1;
            int k=j-1;
            
            while(k<x[0].length&&l>=j){
                result.add(x[l][k]);
                l--;
                k++;
            }

        }
        return result;
    }
    int[] l498findDiagonalOrder(int[][] mat) {

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
    void l73setZeroes(int[][] matrix) {
        //technique is to check each element as it is zero 
        //than mark its corresponding first row and and first column element as zero
        //i.e if the element is m[r][c] than we will mark m[0][c]=0 and m[r][0]=0
        //later on we will again check the each element and verify if its corresponding first column
        //or first row is zero? if yes we will make it zero
        //but before marking on first column on first row we need to check whether they have there original zeros?
        //if yes than make whole column or row zero later on

        //At first before checking other elements we will check first row and column seprately
        //to check there original zeros

        //fr and fc are marker of first row and first column 
        //they have the value if first row or first column contains zero
        int fr=0;
        int fc=0;
        //loop on first row
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                fr++;
            }
        }
        //loop on first column
        for(int j=0;j<matrix.length;j++){
            if(matrix[j][0]==0){
                fc++;
            }
        }

        //traversing each element 
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                //check whether it is zero
                if (matrix[i][j] == 0) {
                    //make its corresponding first row and first column zero
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //again traversing each element to finally setting zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                //if any of the first row or coulumn is zero make that element zero
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //now if our first row originally have zero make the whole row zero
        if(fr>0){
            for(int j=0;j<matrix[0].length;j++){
            matrix[0][j]=0;
            }
        }
        // same for first column
        if(fc>0){
            for(int i=0;i<matrix.length;i++){
            matrix[i][0]=0;
        }
        }  
    }
    List<Integer> l54spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        //simple logical traversing approach
        // we will use four pointers such as sr er sc and ec
        //which will give us some boundries for each spiral rotation
        //we will change there values after each spiral rotation
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int sr=0;
        int er=matrix.length;
        int sc=0;
        int ec=matrix[0].length;
        //while loop will iterate after each spiral rotation
        while(sr<er&&sc<ec){
            //moving first(horizontal) right without constraints 
            //can also traverse on ec 
            for(int i=sc;i<ec;i++){
                ans.add(matrix[sr][i]);
            }
            //moving first(vertical) down but we have to skip sr as its already traversed in first right
            //can also travesrse on er
            for(int i=sr+1;i<er;i++){
                ans.add(matrix[i][ec-1]);
            }
            
            //if our sr and er-1(actual er) are equal it tells us that only a single row is there to 
            //traverse but in the first right we have already traversed it 
            //so we cant traverse it again thats why we check this condition 
            //we will check this condition every time for our second horizontal and second vertical traversal
            //to avoid the duplicates
            if (sr < er - 1) {
                //moving second(horizontal) left but we have to skip ec
                //can also traverse sc 
                for (int i = ec - 2; i >= sc; i--) {
                    ans.add(matrix[er - 1][i]);
                }
            }
            //again checking the same condition for second vertical
            if (sc < ec - 1) { 
                //moving second(vertical) up but we have to skip er
                //and also skip sr as it is already traversed in first right
                for (int i = er - 2; i > sr; i--) {
                    ans.add(matrix[i][sc]);
                }
            }
            sr++;
            er--;
            sc++;
            ec--;
        
        }
        return ans;
    }
    double l643findMaxAverage(int[] nums, int k) {
        double maxavg=Integer.MIN_VALUE;
        int l=0;
        int sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            if(r-l+1==k){
                double avg = (double) sum / k;
                maxavg=Math.max(avg,maxavg);
                sum-=nums[l];
                l++;
            }
        }
        return maxavg;
    }   

}

    

