package WeightedQuickUnion;

public class Main {
    public static void main(String[] args) {
        WeightedQuickUnion qu = new WeightedQuickUnion(10);

        qu.union(4,3);
        qu.union(3,8);
        qu.union(6,5);
        qu.union(9,4);
        qu.union(2,1);
        qu.union(5,0);
        qu.union(7,2);
        qu.union(6,1);
        qu.union(7,3);

        WeightedQuickUnion qu2 = new WeightedQuickUnion(9);
        qu.union(0,3);
        qu.union(3,6);
        qu.connected(0,6);

    }
}
