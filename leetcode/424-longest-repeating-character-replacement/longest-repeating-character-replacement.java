class Solution {
    public int characterReplacement(String s, int k) {

        // Left boundary of our sliding window
        int l = 0;

        // Stores the maximum length of a valid window
        int maxlen = 0;

        /*
         * maxfreq = highest frequency of any character
         * that we have seen while expanding the window.
         *
         * IMPORTANT:
         * We DO NOT decrease maxfreq when 'l' moves.
         *
         * Example:
         *
         * Initially:
         *     A A A B A
         *
         * A appears 4 times
         * maxfreq = 4
         *
         * Later, when the window moves towards 'C',
         * some/all A's may leave the window.
         *
         * The actual frequency inside the current window
         * may now be smaller than 4.
         *
         * But we still keep:
         *     maxfreq = 4
         *
         * This is intentional.
         *
         * maxfreq means:
         * "The highest frequency I have seen so far"
         *
         * NOT:
         * "The exact highest frequency in the current window"
         *
         * Keeping this value makes the solution O(n)
         * without repeatedly finding the maximum frequency.
         */
        int maxfreq = 0;

        // Stores frequency of characters in the current window
        HashMap<Character, Integer> m = new HashMap<>();

        // Expand the window using the right pointer
        for (int r = 0; r < s.length(); r++) {

            // Character entering the window
            char ch = s.charAt(r);

            // Increase its frequency
            m.put(ch, m.getOrDefault(ch, 0) + 1);

            /*
             * Update maxfreq.
             *
             * We only increase maxfreq.
             * We NEVER decrease it when the left pointer moves.
             */
            maxfreq = Math.max(maxfreq, m.get(ch));

            /*
             * Window size:
             *     r - l + 1
             *
             * Suppose:
             *     A A A B A
             *
             * Window size = 5
             * maxfreq = 4 (A appears 4 times)
             *
             * We keep the 4 A's and replace the remaining
             * 1 character.
             *
             * Therefore:
             *
             * changesneeded = window size - maxfreq
             *                = 5 - 4
             *                = 1
             */
            int changesneeded = (r - l + 1) - maxfreq;

            /*
             * If changesneeded > k,
             * we cannot make the entire window the same
             * using at most k replacements.
             *
             * So we shrink the window from the left.
             */
            while (changesneeded > k) {

                // Character leaving the window
                char leftChar = s.charAt(l);

                // Decrease its frequency
                m.put(leftChar, m.get(leftChar) - 1);

                // Remove it from the map if frequency becomes 0
                if (m.get(leftChar) == 0) {
                    m.remove(leftChar);
                }

                // Move left pointer forward
                l++;

                /*
                 * Recalculate changes needed for the
                 * new smaller window.
                 *
                 * IMPORTANT:
                 * maxfreq is NOT recalculated/decreased here.
                 *
                 * It may be larger than the actual maximum
                 * frequency of the current window.
                 *
                 * That's okay and is an intentional optimization
                 * used by the standard O(n) solution.
                 */
                changesneeded = (r - l + 1) - maxfreq;
            }

            /*
             * Now changesneeded <= k.
             *
             * So our current window is considered valid.
             *
             * Update the answer.
             */
            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }
}