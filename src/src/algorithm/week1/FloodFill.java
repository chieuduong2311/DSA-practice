package algorithm.week1;

import java.util.Stack;

public class FloodFill {
    //    issue 733
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int targetValue = image[sr][sc];
        if (targetValue == color) {
            return image;
        }

        boolean[][] visited = new boolean[image.length][image[0].length];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] {sr, sc});
        while (!stack.empty()) {
            int[] current = stack.peek();
            image[current[0]][current[1]] = color;
            visited[current[0]][current[1]] = true;

            int[] next = getNextPixel(current, visited, targetValue, image);

            if (next[0] == -1) {
                stack.pop();
            } else {
                stack.add(next);
            }
        }
        return image;
    }

    private int[] getNextPixel(int[] current, boolean[][] visited, int target, int[][] image) {
        if (current[0] + 1 < visited.length && !visited[current[0] + 1][current[1]] && image[current[0] + 1][current[1]] == target) {
            return new int[] {current[0] + 1, current[1]};
        }
        if (current[0] - 1 >= 0 && !visited[current[0] - 1][current[1]] && image[current[0] - 1][current[1]] == target) {
            return new int[] {current[0] - 1, current[1]};
        }
        if (current[1] + 1 < visited[0].length && !visited[current[0]][current[1] + 1] && image[current[0]][current[1] + 1] == target) {
            return new int[] {current[0], current[1] + 1};
        }
        if (current[1] - 1 >= 0 && !visited[current[0]][current[1] - 1] && image[current[0]][current[1] - 1] == target) {
            return new int[] {current[0], current[1] - 1};
        }
        return new int[] {-1};
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();

        int[][] data = {{0,0,0},{0,1,0}};
        int[][] result = floodFill.floodFill(data, 0, 0, 2);
        System.out.println("done");
    }
}
