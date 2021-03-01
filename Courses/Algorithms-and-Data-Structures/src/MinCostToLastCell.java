public class MinCostToLastCell {
    public static void main(String[] args) {
        MinCostToLastCell mc = new MinCostToLastCell();
        int[][] grid = {{4, 7, 8, 6, 4},
                        {6, 7, 3, 9, 2},
                        {3, 8, 1, 2, 4},
                        {7, 1, 7, 3, 7},
                        {2, 9, 8, 9, 3}};
        int res = mc.minCost(grid);
        System.out.println(res);
    }

    public int minCost(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        return minCost(grid, 0, 0);
    }

    private int minCost(int[][] grid, int r, int c) {
        int rNum = grid.length;
        int cNum = grid[0].length;
        //base case
        if (r == rNum || c == cNum) return Integer.MAX_VALUE;
        if (r == rNum-1 && c == cNum-1) return grid[r][c];

        //recursion
        int costRight = minCost(grid, r, c+1);
        int costDown = minCost(grid, r+1, c);
        System.out.println("right: " + costRight);
        System.out.println("down: " + costDown);
        return grid[r][c] + Math.min(costRight, costDown);
    }
}