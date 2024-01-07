package SocialNetworkSolution;

public class SocialNetworkSolution {
    private int[] id;      // parent link (an array where id[i] is the parent of i)
    private int[] size;    // size of the connected component rooted at i
    private int count;     // number of connected components

    public SocialNetworkSolution(int n) {
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean areAllMembersConnected() {
        return count == 1;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        // Weighted union: attach smaller tree to larger tree
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        count--;
    }

    public int find(int p) {
        // Path compression: make every other node in the path point to its grandparent
        while (p != id[p]) {
            id[p] = id[id[p]];  // Two-pass implementation for path compression
            p = id[p];
        }
        return p;
    }

    public static int earliestTimeOfFullConnectivity(int n, int[][] timestamps) {
        SocialNetworkSolution uf = new SocialNetworkSolution(n);

        for (int[] timestamp : timestamps) {
            int member1 = timestamp[0];
            int member2 = timestamp[1];

            uf.union(member1, member2);

            if (uf.areAllMembersConnected()) {
                return timestamp[2];  // Return the timestamp when all members are connected
            }
        }

        return -1;  // Return -1 if not all members are connected
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] timestamps = {
                {0, 1, 1},
                {1, 2, 2},
                {3, 4, 3},
                {4, 5, 4},
                {2, 4, 5}
        };

        int earliestTime = earliestTimeOfFullConnectivity(n, timestamps);
        System.out.println("Earliest time of full connectivity: " + earliestTime);
    }
}

