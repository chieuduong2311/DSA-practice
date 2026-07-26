package algorithm.codility.concept1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise {

    public static class HSegment {
        public int row;
        public int colStart;
        public int colEnd;
        public int length;

        public HSegment(int row, int colStart, int colEnd) {
            this.row = row;
            this.colStart = colStart;
            this.colEnd = colEnd;
            this.length = colEnd - colStart + 1;
        }
    }

    public static class VSegment {
        public int col;
        public int rowStart;
        public int rowEnd;
        public int length;

        public VSegment(int col, int rowStart, int rowEnd) {
            this.col = col;
            this.rowStart = rowStart;
            this.rowEnd = rowEnd;
            this.length = rowEnd - rowStart + 1;
        }
    }

//    Exercise 1: Extract Horizontal Segments
//    Scan each row and extract all continuous runs of specific cells ('.') as segments.

    public static List<HSegment> extractHorizontalSegments(char[][] grid) {
        List<HSegment> result = new ArrayList<>();
        for (int i = 0; i < grid.length ; i++) {
            int start = 0, end = 0;
            boolean isClosed = true;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '.' && !isClosed) {
                    HSegment hSegment = new HSegment(i, start, end);
                    result.add(hSegment);
                    isClosed = true;
                    continue;
                }
                if (grid[i][j] == '.' && isClosed) {
                    start = end = j;
                    isClosed = false;
                } else {
                    end = j;
                }
            }
            if (!isClosed) {
                HSegment hSegment = new HSegment(i, start, end);
                result.add(hSegment);
            }
        }
        return result;
    }

//    Exercise 2: Extract Vertical Segments
//    Scan each column and extract all continuous runs of specific cells as segments.

    public static List<VSegment> extractVerticalSegments(char[][] grid) {
        List<VSegment> result = new ArrayList<>();
        if (grid.length == 0) {
            return result;
        }
        for (int i = 0; i < grid[0].length ; i++) {
            int start = 0, end = 0;
            boolean isClosed = true;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] != '.' && !isClosed) {
                    VSegment vSegment = new VSegment(i, start, end);
                    result.add(vSegment);
                    isClosed = true;
                    continue;
                }
                if (grid[j][i] == '.' && isClosed) {
                    start = end = j;
                    isClosed = false;
                } else {
                    end = j;
                }
            }
            if (!isClosed) {
                VSegment vSegment = new VSegment(i, start, end);
                result.add(vSegment);
            }
        }
        return result;
    }

//    Exercise 3: Filter Best Per Row
//    From list of HSegments, keep only the longest segment for
//    each unique row. This reduces search space for pair enumeration
    public static List<HSegment> filterBestPerRow(List<HSegment> hSegments) {
        if (hSegments.isEmpty()) {
            return  new ArrayList<>();
        }
        Map<Integer, HSegment> longestHSegmentMap = new HashMap<>();
        for (HSegment hSegment : hSegments) {
            longestHSegmentMap.computeIfAbsent(hSegment.row, k -> hSegment);
            if (longestHSegmentMap.get(hSegment.row).length < hSegment.length) {
                longestHSegmentMap.put(hSegment.row, hSegment);
            }
        }
        return new ArrayList<>(longestHSegmentMap.values());
    }

//    Exercise 4: Filter Best Per Column
//    From list of VSegments, keep only the longest segment for
//    each unique column.
    public static List<VSegment> filterBestPerColumn(List<VSegment> vSegments) {
        if (vSegments.isEmpty()) {
            return  new ArrayList<>();
        }
        Map<Integer, VSegment> longestVSegmentMap = new HashMap<>();
        for (VSegment vSegment : vSegments) {
            longestVSegmentMap.computeIfAbsent(vSegment.col, k -> vSegment);
            if (longestVSegmentMap.get(vSegment.col).length < vSegment.length) {
                longestVSegmentMap.put(vSegment.col, vSegment);
            }
        }
        return new ArrayList<>(longestVSegmentMap.values());
    }

//    Exercise 5: Check Horizontal Overlap
//    Two horizontal segments overlap if they're on the same row and
//    their column ranges overlap.
    public static boolean checkHorizontalOverlap(HSegment seg1, HSegment seg2) {
        if (seg1.row != seg2.row) {
            return false;
        }
        return !(seg2.colStart > seg1.colEnd || seg1.colStart > seg2.colEnd);
    }

//    Exercise 6: Check Vertical Overlap
//    Two vertical segments overlap if they're on the same column and
//    their row ranges overlap.
    public static boolean checkVerticalOverlap(VSegment seg1, VSegment seg2) {
        if (seg1.col != seg2.col) {
            return false;
        }
        return !(seg2.rowStart > seg1.rowEnd || seg1.rowStart > seg2.rowEnd);
    }

//    Exercise 7: Check Cross Intersection
//    Horizontal and vertical segments intersect if
//    - V's columns is within H's column range
//    - H's row is within V's row range
    public static boolean checkCrossIntersection(HSegment hSegment, VSegment vSegment) {
        return vSegment.col >= hSegment.colStart && vSegment.col <= hSegment.colEnd && hSegment.row >= vSegment.rowStart && hSegment.row <= vSegment.rowEnd;
    }

//    Exercise 8: Split Horizontal at Column
//    Split horizontal segment at column (excluding that column)
//    Return lengths of left and right parts. Clamp negatives to zero
    public static int[] splitHorizontalAtColumn(HSegment hSegment, int splitCol) {
        return null;
    }

//    Exercise 9: Split Vertical at Row
//    Split vertical segment at row (excluding that row)
//    Return lengths of top and bottom parts.
    public static int[] splitVerticalAtRow(VSegment vSegment, int splitRow) {
        return null;
    }

//    Exercise 10: Resolve Cross Intersection
//    Complete solution orchestrating previous exercises for maximum coverage calculation
    public static int resolveCrossIntersection(HSegment hSegment, VSegment vSegment) {
        return 0;
    }
}

