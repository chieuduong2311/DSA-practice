package algorithm.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidAnagram {
//    issue 242
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//        Map<Character, Integer> countMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            countMap.merge(s.charAt(i), 1, Integer::sum);
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            Integer value = countMap.get(t.charAt(i));
//            if (value == null || value == 0) {
//                return false;
//            }
//            countMap.put(t.charAt(i), value - 1);
//        }
//
//        return true;

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            countMap.putIfAbsent(s.charAt(i), 0);
            countMap.compute(s.charAt(i), (k,v) -> ++v);

            countMap.putIfAbsent(t.charAt(i), 0);
            countMap.compute(t.charAt(i), (k,v) -> --v);

        }

        for (Integer count : countMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    //DFS tim duong toi target
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        if (toRow >= gameMatrix.length || toColumn >= gameMatrix[0].length) {
            return false;
        }
        if (!gameMatrix[toRow][toColumn]) {
            return false;
        }
        boolean[][] visited = new boolean[gameMatrix.length][gameMatrix[0].length];
        Stack<int[]> path = new Stack<>();
        path.add(new int[] {fromRow, fromColumn});
        while (!path.isEmpty()) {
            int[] currentPos = path.peek();
            int i = currentPos[0];
            int j = currentPos[1];
            if (i == toRow & j == toColumn) {
                return true;
            }
            visited[i][j] = true;
            int[] nextPos = getNextPixel(currentPos, visited, gameMatrix);
            if (nextPos[0] != -1) {
                path.add(nextPos);
            } else path.pop();
        }
        return false;
    }


    public static int[] getNextPixel(int[] current, boolean[][] visited, boolean[][] image) {
        if (current[0] + 1 < visited.length && !visited[current[0] + 1][current[1]] && image[current[0] + 1][current[1]]) {
            return new int[] {current[0] + 1, current[1]};
        }
        if (current[0] - 1 >= 0 && !visited[current[0] - 1][current[1]] && image[current[0] - 1][current[1]]) {
            return new int[] {current[0] - 1, current[1]};
        }
        if (current[1] + 1 < visited[0].length && !visited[current[0]][current[1] + 1] && image[current[0]][current[1] +1]) {
            return new int[] {current[0], current[1] + 1};
        }
        if (current[1] - 1 >= 0 && !visited[current[0]][current[1] - 1] && image[current[0]][current[1] - 1]) {
            return new int[] {current[0], current[1] - 1};
        }
        return new int[] {-1};
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        var s = "anagram";
        var t = "nagaram";

        System.out.println(validAnagram.isAnagram(s, t));
    }
}
