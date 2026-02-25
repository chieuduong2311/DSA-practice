package algorithm.week4;

import java.util.ArrayDeque;

public class RottingOranges {
//    issue 994
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        int[][] minutes = new int[grid.length][grid[0].length];
        int totalOranges = 0;
        var q = new ArrayDeque<int[]>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                }
                if (grid[i][j] == 1) {
                    totalOranges++;
                    continue;
                }
                q.add(new int[] {i, j, 0});
//                minutes[i][j] = 0;
                totalOranges++;
            }
        }

        if (q.isEmpty() && totalOranges > 0) {
            return -1;
        }

        int rottenOranges = 0;
        int[] idx = new int[3];
        while (!q.isEmpty()) {
            idx = q.poll();

            visited[idx[0]][idx[1]] = true;
            rottenOranges++;

            if (idx[0] - 1 >= 0 && !visited[idx[0] - 1][idx[1]] && grid[idx[0] - 1][idx[1]] == 1) {
                q.add(new int[] {idx[0] - 1, idx[1], idx[2] + 1});
                visited[idx[0] - 1][idx[1]] = true;
//                minutes[idx[0] - 1][idx[1]] = minutes[idx[0]][idx[1]] + 1;
            }

            if (idx[1] - 1 >= 0 && !visited[idx[0]][idx[1] - 1] && grid[idx[0]][idx[1] - 1] == 1) {
                q.add(new int[] {idx[0], idx[1] - 1, idx[2] + 1});
//                minutes[idx[0]][idx[1] - 1] = minutes[idx[0]][idx[1]] + 1;
                visited[idx[0]][idx[1] - 1] = true;
            }

            if (idx[0] + 1 < grid.length && !visited[idx[0] + 1][idx[1]] && grid[idx[0] + 1][idx[1]] == 1) {
                q.add(new int[] {idx[0] + 1, idx[1], idx[2] + 1});
//                minutes[idx[0] + 1][idx[1]] = minutes[idx[0]][idx[1]] + 1;
                visited[idx[0] + 1][idx[1]] = true;
            }

            if (idx[1] + 1 < grid[0].length && !visited[idx[0]][idx[1] + 1] && grid[idx[0]][idx[1] + 1] == 1) {
                q.add(new int[] {idx[0], idx[1] + 1, idx[2] + 1});
//                minutes[idx[0]][idx[1] + 1] = minutes[idx[0]][idx[1]] + 1;
                visited[idx[0]][idx[1] + 1] = true;
            }
        }

        if (rottenOranges != totalOranges) {
            return -1;
        }

        return idx[2];
    }

    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int[][] grid = {{0}};
        System.out.println(rottingOranges.orangesRotting(grid));
    }

}
