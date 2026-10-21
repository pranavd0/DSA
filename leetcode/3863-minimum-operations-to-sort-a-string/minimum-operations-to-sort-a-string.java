class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Case 1: Already sorted
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

        // Case 2: Impossible to sort
        if (n == 2) {
            return -1;
        }

        // Find minimum and maximum characters
        char min = 'z';
        char max = 'a';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch < min) {
                min = ch;
            }

            if (ch > max) {
                max = ch;
            }
        }

        // Case 3: One operation is sufficient
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Case 4: Two operations are sufficient
        for (int i = 1; i < n - 1; i++) {
            char ch = s.charAt(i);

            if (ch == min || ch == max) {
                return 2;
            }
        }

        // Case 5: Three operations are necessary
        return 3;
    }
}
