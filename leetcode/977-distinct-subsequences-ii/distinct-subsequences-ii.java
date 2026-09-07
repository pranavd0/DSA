class Solution {
    public int distinctSubseqII(String s) {

        final int MOD = 1_000_000_007;

        /*
         * dp represents the number of distinct non-empty subsequences
         * we can form using the characters processed so far.
         *
         * For every new character c:
         *
         * Every existing subsequence can either:
         * 1. NOT take c
         * 2. Take c at the end
         *
         * So normally:
         *
         *     newDp = 2 * dp + 1
         *
         * The +1 represents the subsequence consisting only of c.
         *
         * BUT:
         * If c has appeared before, some subsequences are duplicated.
         *
         * The duplicated subsequences are exactly the subsequences
         * that were already created when c appeared previously.
         *
         * Therefore, we subtract the previous contribution of c.
         */

        long dp = 0;

        /*
         * last[c] stores the value of dp BEFORE the previous occurrence
         * of character c was processed.
         *
         * This represents exactly the number of subsequences that would
         * be duplicated when we encounter c again.
         *
         * Since input contains lowercase English letters,
         * an array of size 26 is enough.
         */
        long[] last = new long[26];

        for (char ch : s.toCharArray()) {

            int idx = ch - 'a';

            /*
             * Save the current number of distinct subsequences
             * before processing this character.
             */
            long previousDp = dp;

            /*
             * Add the current character to:
             *
             * - every existing subsequence -> dp
             * - the empty subsequence -> 1
             *
             * Hence 2 * dp + 1.
             *
             * Then subtract the contribution generated during the
             * previous occurrence of this same character.
             */
            dp = (2 * dp + 1 - last[idx] + MOD) % MOD;

            /*
             * Store the contribution BEFORE processing this occurrence.
             *
             * If this character appears again, this is the amount
             * that needs to be removed to prevent duplicate subsequences.
             */
            last[idx] = previousDp + 1;

            /*
             * Why +1?
             *
             * The previous occurrence also created the subsequence
             * consisting of that character alone.
             *
             * So its total contribution was:
             *
             *     previousDp + 1
             */
        }

        /*
         * dp contains the number of distinct NON-EMPTY subsequences.
         */
        return (int) dp;
    }
}
