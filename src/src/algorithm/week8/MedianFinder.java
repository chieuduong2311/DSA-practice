package algorithm.week8;

import java.util.ArrayList;

public class MedianFinder {
//    issue 295
    private ArrayList<Integer> data;
    public MedianFinder() {
        data = new ArrayList<>();
    }

    public void addNum(int num) {
        if (data.isEmpty()) {
            data.add(num);
            return;
        }
        int start = 0, end = data.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (data.get(mid) == num) {
                data.add(mid, num);
                return;
            }
            if (data.get(mid) > num) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        if (data.get(start) < num) {
            data.add(start + 1, num);
        } else data.add(start, num);
    }


    public double findMedian() {
        if (data.isEmpty()) {
            return 0;
        }
        int size = data.size();
        if (size % 2 == 1) {
            return data.get(size/2);
        }
        return (double) (data.get(size / 2) + data.get(size / 2 - 1)) /2;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
//        medianFinder.addNum(-5);
//        medianFinder.addNum(-2);
        medianFinder.addNum(3);
//        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
    }
}