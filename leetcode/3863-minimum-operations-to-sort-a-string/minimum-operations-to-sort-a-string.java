class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Step 1: Check if string is already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }

        // Step 2: Impossible to sort when length is 2 and unsorted
        if (n == 2) {
            return -1;
        }

        // Step 3: Find minimum and maximum characters
        char min = 'z';
        char max = 'a';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch < min) min = ch;
            if (ch > max) max = ch;
        }

        // Step 4: One operation if min is first or max is last
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Step 5: Two operations if min or max is in the middle
        for (int i = 1; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == min || ch == max) {
                return 2;
            }
        }

        // Step 6: Three operations required
        return 3;
    }
}
