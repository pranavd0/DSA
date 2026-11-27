class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int mn = INT_MAX, mx = 0;

        for (auto& x : items) {
            mn = min(mn, x[1]);
            mx = max(mx, x[0]);
        }

        vector<int> freq(mx + 1, 0), gain(mx + 1, 0);

        for (auto& x : items)
            freq[x[0]]++;

        // Count purchased + free items using sieve
        for (int i = 1; i <= mx; i++) {
            if (!freq[i]) continue;

            for (int j = i; j <= mx; j += i)
                gain[i] += freq[j];
        }

        vector<int> dp(budget + 1);

        // Buy cheapest items using available budget
        for (int b = 0; b <= budget; b++)
            dp[b] = b / mn;

        // 0/1 Knapsack
        for (auto& x : items) {
            int f = x[0], p = x[1];

            for (int b = budget; b >= p; b--)
                dp[b] = max(dp[b], dp[b - p] + gain[f]);
        }

        return dp[budget];
    }
};
