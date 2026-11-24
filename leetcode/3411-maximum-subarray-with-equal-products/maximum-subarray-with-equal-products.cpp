class Solution {
public:
    int maxLength(vector<int>& nums) {
        int masks[] = {0, 0, 1, 2, 1, 4, 3, 8, 1, 2, 5};

        int l = 0, mask = 0, ans = 2;

        for (int r = 0; r < nums.size(); r++) {
            int curr = masks[nums[r]];

            while (mask & curr) {
                mask ^= masks[nums[l]];
                l++;
            }

            mask |= curr;
            ans = max(ans, r - l + 1);
        }

        return ans;
    }
};
