package dynamicConnectivity;

import java.util.Arrays;

public class ImprovedQuickUnionMain {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        DynamicConnectivity improvedQuickUnion = new ImprovedQuickUnion();
        improvedQuickUnion.init(n);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        improvedQuickUnion.union(4, 3);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        improvedQuickUnion.union(3, 8);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        improvedQuickUnion.union(6, 5);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        improvedQuickUnion.union(9, 4);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        improvedQuickUnion.union(2, 1);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        if (improvedQuickUnion.connected(8, 9)) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }

        if (improvedQuickUnion.connected(5, 0)) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }

        improvedQuickUnion.union(5, 0);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        improvedQuickUnion.union(7, 2);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

        improvedQuickUnion.union(6, 1);
        System.out.println(Arrays.toString(improvedQuickUnion.getPoints()));

    }
}
