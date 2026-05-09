package algorithm.extra;

import java.util.Arrays;
import java.util.Map;

public class RangeMinimumQuery {
    private static final Map<Character, Integer> mapping = Map.of(
            'A', 1,
            'C', 2,
            'G', 3,
            'T', 4
    );
    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        for (int j = 0; j < P.length ; j++) {
            int start = P[j], end = Q[j];
            if (start == end) {
                result[j] = mapping.get(S.charAt(start));
                continue;
            }
            char min = S.charAt(start);
            for (int i = start + 1; i <= end ; i++) {

                if (S.charAt(i) < min) {
                    min = S.charAt(i);
                }
            }
            result[j] = mapping.get(min);
        }
        return result;
    }


    public int[] solution2(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        int[][] matrix = new int[S.length()][S.length()];
        for (int i = 0; i < S.length(); i++) {
            findMin(S, i, S.length() - 1, matrix);
        }

        for (int j = 0; j < P.length ; j++) {
            int start = P[j], end = Q[j];
            result[j] = matrix[start][end];
        }
        return result;
    }

    public int findMin(String S, int start, int end, int[][] matrix) {
        if (matrix[start][end] != 0) {
            return matrix[start][end];
        }

        if (start == end) {
            matrix[start][end] = mapping.get(S.charAt(start));
            return mapping.get(S.charAt(start));
        }

        int min = Math.min(findMin(S, start, end - 1, matrix), findMin(S, end, end, matrix));
        matrix[start][end] = min;
        return min;
    }

    public static class SegmentNode {
        private SegmentNode left;
        private SegmentNode right;
        private int min;
        private int start;
        private int end;

        SegmentNode() {}

        SegmentNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
        }
    }

    public SegmentNode buildSegmentTree(String S, int start, int end) {
        if (start == end) {
            return new SegmentNode(start, end, mapping.get(S.charAt(start)));
        }
        SegmentNode root = new SegmentNode();
        root.start = start;
        root.end = end;
        int mid = (end - start)/2 + start;
        root.left = buildSegmentTree(S, start, mid);
        root.right = buildSegmentTree(S, mid+1, end);
        root.min = Math.min(root.left.min, root.right.min);

        return root;
    }

    public int[] solution3(String S, int[] P, int[] Q) {
        SegmentNode tree = buildSegmentTree(S, 0, S.length() - 1);

        int[] result = new int[P.length];


        for (int j = 0; j < P.length ; j++) {
            int start = P[j], end = Q[j];
            result[j] = findMinInTree(tree, start, end);
        }
        return result;
    }

    public int findMinInTree(SegmentNode root, int l, int r) {
        if (root.start >= l && root.end <= r) {
            return root.min;
        } else if (root.start > r || root.end < l) {
            return 5;
        } else return Math.min(findMinInTree(root.left, l, r), findMinInTree(root.right, l, r));
    }

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = new int[] {2, 5, 0};
        int[] Q = new int[] {4, 5, 6};
        System.out.println(Arrays.toString(new RangeMinimumQuery().solution3(S, P, Q)));
        System.out.println("debug");
    }
}
