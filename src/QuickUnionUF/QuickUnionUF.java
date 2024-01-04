package QuickUnionUF;

import java.sql.SQLOutput;
import java.util.Arrays;

public class QuickUnionUF {
    private int[] id;
    private int[] pos;

    public QuickUnionUF(int N) {
        id = new int[N];
        pos = new int[N];

        for(int i = 0; i < N; i++) {
            id[i] = i;
            pos[i] = i;
        }
        printArrays();
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        printMessage("connected", p, q);
        System.out.println(root(p) == root(q));
        System.out.print("\n");
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        // Change root of p to q
        int i = root(p);
        int j = root(q);

        id[i] = j;
        printMessage("union", p, q);
        printArrays();
    }

    private void printArrays() {
        System.out.println(Arrays.toString(pos));
        System.out.println(Arrays.toString(id) + "\n");
    }

    private void printMessage(String type, int p, int q) {
        System.out.println(type+"("+p+","+q+")");
    }
}
