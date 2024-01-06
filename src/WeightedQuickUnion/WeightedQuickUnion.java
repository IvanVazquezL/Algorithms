package WeightedQuickUnion;

import java.util.Arrays;

public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;
    private int[] pos;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        pos = new int[N];

        for(int i = 0; i < N; i++) {
            id[i] = i;
            pos[i] = i;
            sz[i] = 1;
        }

        printArrays();
    }
    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        printMessage("union", p, q);
        printArrays();
    }

    private void printArrays() {
        System.out.println("id = " + Arrays.toString(pos));
        System.out.println("id = " + Arrays.toString(id) + "\n");

        System.out.println("sz = " + Arrays.toString(pos));
        System.out.println("sz = " + Arrays.toString(sz) + "\n");
    }

    private void printMessage(String type, int p, int q) {
        System.out.println(type+"("+p+","+q+")");
    }
}
