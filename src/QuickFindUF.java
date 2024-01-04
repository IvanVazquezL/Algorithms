import java.util.Arrays;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];

        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        // We give the id of the second element to the first one
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }

        PrintArray();
    }

    public void PrintArray() {
        System.out.println(Arrays.toString(id));
    }
}
