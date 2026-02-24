package algorithm.week4;

public class NumberIslands {
//    issue 200
    private int count = 0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (grid[i][j] == '1') {
                    count++;
                    DFS(grid, i, j, visited);
                }

            }
        }
        return count;
    }

    public void DFS(char[][] grid, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (grid[i][j] != '1') {
            return;
        }

        if (i - 1 >= 0) {
            DFS(grid, i - 1, j, visited);
        }

        if (j - 1 >= 0) {
            DFS(grid, i, j - 1, visited);
        }

        if (i + 1 < grid.length) {
            DFS(grid, i + 1, j, visited);
        }

        if (j + 1 < grid[0].length) {
            DFS(grid, i, j + 1, visited);
        }
    }
}
