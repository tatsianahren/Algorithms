package dynamicConnectivity.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {

    private boolean[][] grid;
    private int N;
    private int topNode;
    private int bottomNode;
    private WeightedQuickUnionUF uf;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if(n <= 0){
            throw new IllegalArgumentException();
        }

        uf = new WeightedQuickUnionUF(n*n+1);
        grid = new boolean[n][n];
        N = n;
        topNode = 0;
        bottomNode = n*n+1;
    }

    private int getIndex(int row, int col){
        return N*col + row + 1;
    }

    // open site (row, col) if it is not open already
    public void open(int x, int y) {

        if(x <= 0 || y > N){
            throw new IllegalArgumentException();
        }

        if(!isOpen(x,y)){
            int row = x - 1;
            int col = y - 1;
            grid[row][col] = true;

//            top
            if(col > 0 && isOpen(x, y - 1)){
                uf.union(getIndex(row, col - 1), getIndex(row, col));
            }

            if(col == 0){
                uf.union(topNode, getIndex(row, col));
            }

//            right
            if(row < N - 1 && isOpen(x + 1, y)){
                uf.union(getIndex(row + 1, col), getIndex(row, col));
            }

//            bottom
            if(col < N - 1 && isOpen(x , y +1)){
                uf.union(getIndex(row, col + 1), getIndex(row, col));
            }

            if(col == N - 1){
                uf.connected(bottomNode, getIndex(row, col));
            }

//            left
            if(row > 0 && isOpen(x - 1, y)){
                uf.union(getIndex(row - 1, col), getIndex(row, col));
            }
        }

    }

    // is site (row, col) open?
    public boolean isOpen(int x, int y) {
        int row = x - 1;
        int col = y - 1;

        if(row < 0 || col >= N){
            throw new IllegalArgumentException();
        }

        return grid[row][col];

    }

    // is site (row, col) full?
    public boolean isFull(int x, int y) {
        int row = x - 1;
        int col = y - 1;

        if(row < 0 || col >= N){
            throw new IllegalArgumentException();
        }

        return uf.connected(N*col+row+1, topNode);
    }

    public boolean percolates()  {
        return uf.connected(topNode, bottomNode);
    }

    public static void main(String[] args){
        Percolation percolation = new Percolation(5);

        percolation.open(1, 3);
        percolation.open(2, 4);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(4, 3);
        percolation.open(4, 4);
        percolation.open(5, 1);

        percolation.printGrid();

        System.out.println(percolation.percolates());


    }

    public void printGrid(){
        System.out.println("-----");
        for (int i = 0; i < N; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println("-----");
    }
}
