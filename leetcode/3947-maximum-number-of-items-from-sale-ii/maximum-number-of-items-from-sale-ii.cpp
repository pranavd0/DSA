class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n = items.size();
        int mn = INT_MAX;

        vector<int> freq(n + 1, 0);
        vector<int> cnt(n + 1, 0);

        for (auto& item : items) {
            freq[item[0]]++;
            mn = min(mn, item[1]);
        }

        // Count eligible free items using multiples
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) continue;

            for (int j = i; j <= n; j += i)
                cnt[i] += freq[j];

            cnt[i]--;
        }

        // Sort by price
        sort(items.begin(), items.end(),
             [](const auto& a, const auto& b) {
                 return a[1] < b[1];
             });

        int ans = 0;

        for (auto& item : items) {
            int f = item[0], p = item[1];

            if (p > 2LL * mn) break;

            int take = min(cnt[f], budget / p);

            ans += 2 * take;
            budget -= take * p;
        }

        // Buy cheapest items with remaining budget
        return ans + budget / mn;
    }
};
