package QuickFindUF;

import QuickFindUF.QuickFindUF;

public class Main {
    public static void main(String[] args) {
        QuickFindUF qf = new QuickFindUF(10);
        System.out.println(qf.connected(3,4));
        qf.union(3,4);
        System.out.println(qf.connected(3,4));
        qf.union(4,8);
        System.out.println(qf.connected(3,8));

    }
}
