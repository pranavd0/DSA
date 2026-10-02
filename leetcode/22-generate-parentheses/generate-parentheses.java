class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder str,
                           int open, int close, int n) {

        // Valid combination completed
        if (str.length() == 2 * n) {
            ans.add(str.toString());
            return;
        }

        // We can add '(' if we haven't used all n
        if (open < n) {
            str.append('(');
            backtrack(ans, str, open + 1, close, n);
            str.deleteCharAt(str.length() - 1);
        }

        // We can add ')' only if it won't make invalid parentheses
        if (close < open) {
            str.append(')');
            backtrack(ans, str, open, close + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
