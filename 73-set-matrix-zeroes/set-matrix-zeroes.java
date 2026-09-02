class Solution {
    public void setZeroes(int[][] matrix) {
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
}