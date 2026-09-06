import java.util.Arrays;

public class Array_Implementation {
    public int binerysearch(int num[],int key){
        int n=num.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+(right-left))/2;

            if(key==num[mid]){
                return mid;
            }

            else if(key>num[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }
        return -1;

    }
    public int[] reverse(int arr[]){
        int left=0;
        int right=arr.length-1;
        int temp;
        
        while(left<right){
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;   
        }
        return arr;
    }
    public void subarray(int arr[]) {
    int total = 0;
    int maxsum = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
        for (int j = i; j < arr.length; j++) {

            int sum = 0;

            for (int a = i; a <= j; a++) {
                System.out.print(arr[a] + " ");
                sum += arr[a];
                total++;
            }

            maxsum = Math.max(maxsum, sum);
            System.out.println(" sum = " + sum);
        }
        System.out.println("");
    }
    
    
        System.out.println("maxsum = " + maxsum);
     System.out.println("total elements printed = " + total);
    }
    public void maxsubarrsum(int arr[]){
        int total=0;
        int maxsub=Integer.MIN_VALUE;
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i =1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=i==0 ? prefix[j] : prefix[j]-prefix[i-1];
                System.out.println(sum);
                maxsub=Math.max(sum, maxsub);
            }
        }
        System.out.println("max subarray="+" "+maxsub );

    }
    public void kedans_maxsum(int[] arr){
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum<0){
                currsum=0;
            }
            
            System.out.println(currsum);
            maxsum=Math.max(maxsum,currsum);
        }
        System.out.println(" ");
        System.out.println("maxsum="+maxsum);


    }
    
    public int rainwater(int[] arr){
        if(arr.length<=2){
            return 0;
        }
        int n=arr.length;
        int leftmax[]=new int[arr.length];
        leftmax[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            leftmax[i]=arr[i];
            if(leftmax[i]<leftmax[i-1]){
                leftmax[i]=leftmax[i-1];
            }

            }
            System.out.print("left max array="+Arrays.toString(leftmax));

        int rightmax[]=new int[arr.length];
        rightmax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=arr[i];
            if(rightmax[i]<rightmax[i+1]){
                rightmax[i]=rightmax[i+1];
            }
            

            }
            System.out.println("");
            System.out.print("right max array="+Arrays.toString(rightmax));
            System.out.println("");
            int totalwater=0;
            for(int i=0;i<n;i++){
                int waterlevel=Math.min(leftmax[i],rightmax[i]);
                int trapwater=waterlevel-arr[i];
                System.out.println("trap water for"+arr[i]+"="+trapwater);
                totalwater+=trapwater;
            }
            System.out.println("Total water="+totalwater);
            return totalwater;


        }
    public int stocksmaxprofit(int arr[]){
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<arr.length;i++){
            int currprice=arr[i];
            if(currprice<=minprice){
                minprice=Math.min(minprice, currprice);
            }
            else{
                int profit=currprice-minprice;
                maxprofit=Math.max(maxprofit, profit);
            }
        }
        System.out.println(maxprofit);
        return maxprofit;
    }
    public int largestin2d(int matrix[][]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max, matrix[i][j]);
                min=Math.min(min, matrix[i][j]);
            }
        }
        System.out.println(min);
                return max;
    }
    public void spiralmatrix(int matrix[][]){
        int sr=0;
        int er=matrix.length-1;
        int sc=0;
        int ec=matrix[0].length-1;
        while(sr<=er&&sc<=ec){
            //top
            for(int i=sc;i<=ec;i++){
                System.out.print(matrix[sc][i]);
            }
            //right
            for(int i=sr+1;i<=er;i++){
                System.out.print(matrix[i][ec]);
            }
            //bottom
            for(int i=ec-1;i>=sc;i--){
                if(sr==er){
                    break;
                }
                System.out.print(matrix[er][i]);
            }
            
            //left
            for(int i=er-1;i>sr;i--){
                if(sc==ec){
                    break;
                }
                System.out.print(matrix[i][sc]);
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
    }
    //public int diagonalsum(int matrix[][]){
    //    int i=0;
        
    //    int sum=0;
    //    while(i<matrix.length){
    //        sum+=matrix[sr][sc];
    //        sr++;
    //        sc++;
    //    }
    //    int i=0;
    //    int j=matrix[0].length-1;
    //    while(i<matrix.length&&j>=0){
    //        sum+=matrix[i][j];
    //        sr++;
    //        sc--;
    //    }
    //    return sum;
    //}

    public void Searchin2d(int matrix[][], int key){
        int n=matrix.length;
        int i=0;
        int j=n-1;
        while(j>=0&&i<n){
            if(key == matrix[i][j]){
                System.out.println("Found at index="+i+","+j);
                return; 
            }
            else if(key<matrix[i][j]){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("element not found");
    }
    

    public static void main(String[] args) {
        Array_Implementation imp=new Array_Implementation();
        int arr[]={7,1,5,3,6,4};
        int key=33;
        int matrix[][]= {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };
        
        
        //Scanner sc=new Scanner(System.in);
        //for(int i=0;i<matrix.length;i++){
        //    for(int j=0;j<matrix[0].length;j++){
        //        matrix[i][j]=sc.nextInt();
        //    }
        
        //}
        //System.out.println(imp.largestin2d(matrix));
        //imp.spiralmatrix(matrix);
        //System.out.print(imp.diagonalsum(matrix));
        imp.Searchin2d(matrix, key);



        //imp.reverse(arr);
        //for(int i=0;i<arr.length;i++){


        //System.out.println(arr[i]);
        //imp.subarray(arr);
        //imp.stocksmaxprofit(arr);
        
    }
}




    
    
    
    
    
    
    
    
    
    
    
    

