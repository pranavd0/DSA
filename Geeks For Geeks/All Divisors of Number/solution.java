/*
 * Platform: GeeksforGeeks
 * Problem: All Divisors of Number
 * URL: https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1
 * Language: Java
 * Difficulty: Easy
 * Topics: Mathematics, Factorization
 * Runtime: 0.18 s
 * Memory: N/A
 * Synced: 2026-10-18T14:20:06.605Z
 */

class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> ls = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ls.add(i);

                if (i != n / i) {
                    ls.add(n / i);
                }
            }
        }

        Collections.sort(ls);
        return ls;
    }
}
