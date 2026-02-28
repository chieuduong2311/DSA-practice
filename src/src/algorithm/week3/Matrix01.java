package algorithm.week3;

import java.util.ArrayDeque;

public class Matrix01 {
//    issue 542
    public int[][] updateMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] minutes = new int[grid.length][grid[0].length];
        var q = new ArrayDeque<int[]>();

        q.add(new int[] {0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] idx = q.poll();
            int i = idx[0];
            int j = idx[1];

            if (grid[i][j] == 0) {
                minutes[i][j] = 0;
            }

            if (idx[0] - 1 >= 0 && !visited[idx[0] - 1][idx[1]]) {
                q.add(new int[] {idx[0] - 1, idx[1]});
                visited[idx[0] - 1][idx[1]] = true;
                minutes[idx[0] - 1][idx[1]] = minutes[idx[0]][idx[1]] + 1;
            }

            if (idx[1] - 1 >= 0 && !visited[idx[0]][idx[1] - 1]) {
                q.add(new int[] {idx[0], idx[1] - 1});
                minutes[idx[0]][idx[1] - 1] = minutes[idx[0]][idx[1]] + 1;
                visited[idx[0]][idx[1] - 1] = true;
            }

            if (idx[0] + 1 < grid.length && !visited[idx[0] + 1][idx[1]]) {
                q.add(new int[] {idx[0] + 1, idx[1]});
                minutes[idx[0] + 1][idx[1]] = minutes[idx[0]][idx[1]] + 1;
                visited[idx[0] + 1][idx[1]] = true;
            }

            if (idx[1] + 1 < grid[0].length && !visited[idx[0]][idx[1] + 1]) {
                q.add(new int[] {idx[0], idx[1] + 1});
                minutes[idx[0]][idx[1] + 1] = minutes[idx[0]][idx[1]] + 1;
                visited[idx[0]][idx[1] + 1] = true;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                System.out.println(minutes[i][j]);
            }
        }
        return minutes;
    }

    public static void main(String[] args) {
        Matrix01 matrix01 = new Matrix01();
        int[][] grid = {{0,0,0},{0,1,0},{1,1,1}};
        var result = matrix01.updateMatrix(grid);
    }
}
