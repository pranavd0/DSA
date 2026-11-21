import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Construct original tree
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];

        Arrays.fill(last, -1);

        // Find nearest ancestor with same character
        dfs1(0, -1, adj, newParent, last, s);

        // Construct modified tree
        List<Integer>[] modified = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            modified[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            modified[newParent[i]].add(i);
        }

        int[] ans = new int[n];

        // Calculate subtree sizes
        dfs2(0, modified, ans);

        return ans;
    }

    private void dfs1(int node, int par, List<Integer>[] adj,
                      int[] newParent, int[] last, String s) {

        int ch = s.charAt(node) - 'a';

        int old = last[ch];

        if (old != -1) {
            newParent[node] = old;
        }

        last[ch] = node;

        for (int child : adj[node]) {
            dfs1(child, node, adj, newParent, last, s);
        }

        last[ch] = old;
    }

    private int dfs2(int node, List<Integer>[] adj, int[] ans) {

        ans[node] = 1;

        for (int child : adj[node]) {
            ans[node] += dfs2(child, adj, ans);
        }

        return ans[node];
    }
}
