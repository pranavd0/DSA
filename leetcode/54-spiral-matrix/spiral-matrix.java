class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
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
}