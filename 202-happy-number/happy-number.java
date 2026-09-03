import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        //unhappy number makes a loop it will form again same number which has already formed
        //hence we will use Hashset as we will need contains function to check that number already seen
        //whenever we get 1 afterwards all the numbers are 1
        //hence contains loop will also stop for 1

        HashSet<Integer> hs = new HashSet<>();
        //this loop will continue until we get the same number again
        while(!hs.contains(n)) {
            hs.add(n);
            //next number calculation
            int sum = 0;
            while(n > 0) {
                int k = n % 10;
                sum += k * k;
                n = n / 10;
            }
            n = sum;   
        }
        //as told in question if number is 1 : happy
        if(n == 1) {
            return true;
        }

        return false;
    }
}