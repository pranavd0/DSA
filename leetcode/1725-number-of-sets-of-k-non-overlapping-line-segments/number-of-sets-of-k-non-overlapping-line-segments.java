
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int r = 2 * k;

        long numerator = 1;
        long denominator = 1;

        for (int i = 1; i <= r; i++) {
            numerator = numerator * (N - r + i) % MOD;
            denominator = denominator * i % MOD;
        }

        long inverse = power(denominator, MOD - 2);

        return (int) (numerator * inverse % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}