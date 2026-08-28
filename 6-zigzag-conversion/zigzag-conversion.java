class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||s.length()<=1){
            return s;
        }

        StringBuilder[] row= new StringBuilder[numRows];
        //making a commom Stringbuilder array for all rows whic contains separate stringbuilders for each rows
        for(int i=0;i<numRows;i++){
            row[i]=new StringBuilder();
            //making seprate string builder for each row 
        }

        int currRow=0;
        boolean direction=false;
        //direction enable us to move up or down if its true than we move down the rows and if its false we move up the rows
        for(char ch: s.toCharArray()){
            row[currRow].append(ch);

            if(currRow==0||currRow==(numRows-1)){
                direction=!direction;
            }
            currRow+= direction ? 1 :-1;
        }
        StringBuilder finalrow=new StringBuilder();
        //combining all the stringbuilder for each rows
        for(StringBuilder abc: row){
            finalrow.append(abc);
        }
        return finalrow.toString();
        
    }
}