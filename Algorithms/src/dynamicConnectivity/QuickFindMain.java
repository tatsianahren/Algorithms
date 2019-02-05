package dynamicConnectivity;

import java.util.Arrays;

public class QuickFindMain {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        DynamicConnectivity quickFind = new QuickFind();
        quickFind.init(n);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        quickFind.union(4, 3);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        quickFind.union(3, 8);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        quickFind.union(6, 5);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        quickFind.union(9, 4);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        quickFind.union(2, 1);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        if (quickFind.connected(8, 9)) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }

        if (quickFind.connected(5, 0)) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }

        quickFind.union(5, 0);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        quickFind.union(7, 2);
        System.out.println(Arrays.toString(quickFind.getPoints()));

        quickFind.union(6, 1);
        System.out.println(Arrays.toString(quickFind.getPoints()));

    }
}
