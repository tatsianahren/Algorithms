package dynamicConnectivity;

import java.util.Arrays;

public class QuickUnionMain {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        DynamicConnectivity quickUnion = new QuickUnion();
        quickUnion.init(n);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        quickUnion.union(4, 3);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        quickUnion.union(3, 8);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        quickUnion.union(6, 5);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        quickUnion.union(9, 4);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        quickUnion.union(2, 1);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        if (quickUnion.connected(8, 9)) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }

        if (quickUnion.connected(5, 0)) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }

        quickUnion.union(5, 0);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        quickUnion.union(7, 2);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

        quickUnion.union(6, 1);
        System.out.println(Arrays.toString(quickUnion.getPoints()));

    }
}
