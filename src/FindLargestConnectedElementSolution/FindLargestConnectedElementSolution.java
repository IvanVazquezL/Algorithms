package FindLargestConnectedElementSolution;

public class FindLargestConnectedElementSolution {
    private int[] id;       // parent link (an array where id[i] is the parent of i)
    private int[] size;     // size of the connected component rooted at i
    private int[] largest;  // largest element in the connected component rooted at i
    private int count;      // number of connected components

    public FindLargestConnectedElementSolution(int n) {
        count = n;
        id = new int[n];
        size = new int[n];
        largest = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
            largest[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public int find(int p) {
        validate(p);
        return largest[findRoot(p)];
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if (rootP == rootQ) return;

        // Weighted union: attach smaller tree to larger tree
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
            updateLargest(rootQ, largest[rootP]);
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
            updateLargest(rootP, largest[rootQ]);
        }

        count--;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p) {
        // Path compression: make every other node in the path point to its grandparent
        while (p != id[p]) {
            id[p] = id[id[p]];  // Two-pass implementation for path compression
            p = id[p];
        }
        return p;
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n-1));
        }
    }

    private void updateLargest(int root, int candidate) {
        if (candidate > largest[root]) {
            largest[root] = candidate;
        }
    }

    public static void main(String[] args) {
        FindLargestConnectedElementSolution uf = new FindLargestConnectedElementSolution(10);

        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);

        System.out.println(uf.find(1));  // Should print 3 (largest in {1, 2, 3})
        System.out.println(uf.find(4));  // Should print 5 (largest in {4, 5})
    }
}

