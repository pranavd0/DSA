class Solution {
public:
    vector<string> ans;

    vector<string> mp = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    void solve(string& digits, int i, string& temp) {
        if (i == digits.size()) {
            ans.push_back(temp);
            return;
        }

        for (char ch : mp[digits[i] - '0']) {
            temp.push_back(ch);
            solve(digits, i + 1, temp);
            temp.pop_back();
        }
    }

    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};

        string temp;
        solve(digits, 0, temp);

        return ans;
    }
};
