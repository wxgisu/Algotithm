import java.util.*;

public class NumOfPaths {
    public static void main(String[] args) {
        NumOfPaths np = new NumOfPaths();
        int[][] grid = {{4, 7, 1, 6},
                        {5, 7, 3, 9},
                        {3, 2, 1, 2},
                        {7, 1, 6, 3}};
        int totalCost = 25;
        int res = np.numPath(grid, totalCost);
        System.out.println(res);
    }

    public int numPath(int[][] grid, int totalCost) {
        if (grid == null || grid.length == 0) return 0;
        return numPath(grid, 0, 0, totalCost, new ArrayList<>());
    }

    private int numPath(int[][] grid, int r, int c, int costToSpare, List<int[]> path) {
        int nR = grid.length;
        int nC = grid[0].length;
        //base case
        //1. no more cost to spare
        if (costToSpare < 0) return 0;
        //2. at end cell
        if (r == nR-1 && c == nR-1)
            // return (costToSpare - grid[r][c] >= 0) ? 1 : 0;
            if (costToSpare - grid[r][c] == 0) {
                path.add(new int[]{r, c});
                for (int[] p : path) {
                    System.out.println(p[0] + ", " + p[1]);
                }
                System.out.println("-----------");
                return 1;
            }   else {
                return 0;
            }
        
        //recursion
        
        if (r == nR-1)
            return numPath(grid, r, c+1, costToSpare-grid[r][c], path);
        if (c == nC-1)
            return numPath(grid, r+1, c, costToSpare-grid[r][c], path);
        int npToRight = numPath(grid, r, c+1, costToSpare-grid[r][c], path);
        int npToDown = numPath(grid, r+1, c, costToSpare-grid[r][c], path);
        if (npToRight + npToDown > 0) path.add(new int[]{r, c});
        return npToRight + npToDown;
    }
}