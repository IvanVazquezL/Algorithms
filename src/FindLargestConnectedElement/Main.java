package FindLargestConnectedElement;

import WeightedQuickUnion.WeightedQuickUnion;

public class Main {
    public static void main(String[] args) {
        FindLargestConnectedElement qu = new FindLargestConnectedElement(10);

        qu.union(4,3);
        qu.union(3,8);
        qu.union(6,5);

        System.out.println(qu.find(4));
    }
}
