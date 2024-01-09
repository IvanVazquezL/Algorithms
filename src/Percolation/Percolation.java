package Percolation;

import QuickUnionUF.QuickUnionUF;

import java.util.Arrays;

public class Percolation {

    private int[][] grid;
    private int countOpenSites;
    private QuickUnionUF qu;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        grid = new int[n][n];
        countOpenSites = 0;
        qu = new QuickUnionUF(n*n);

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                grid[row][col] = 0;
            }
        }
        printGrid();
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col) || isFull(row, col)) return;
        grid[row][col] = 1;
        countOpenSites++;


        printGrid();
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return grid[row][col] == 2;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        for(int j = 0; j < grid.length; j++) {
            if (isFull(grid.length - 1,j)) return true;
        }
        return false;
    }

    private void printGrid() {
        for(int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println("");
    }
}
