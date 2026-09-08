class Solution {
    public int countCommas(int n) {
        int count = 0;

        // Each number from 1000 onwards has at least 1 comma
        for (long place = 1000; place <= n; place *= 1000) {
            count += n - place + 1;
        }

        return count;
    }
}