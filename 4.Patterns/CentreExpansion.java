public class CentreExpansion {
    int l05HelperExpand(String s,int left, int right){
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            int length=(right-1)-(left+1)+1;
            return length;//due to right ++ and left-- are after while(inside while) the right increased by extra 1 same for left and hence that extra 1 is first removed and than length is calculated
    }
}
