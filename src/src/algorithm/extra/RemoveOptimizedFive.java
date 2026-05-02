package algorithm.extra;

import java.util.ArrayList;

public class RemoveOptimizedFive {
    public int solution(int N) {
        ArrayList<Integer> digits = new ArrayList<>();
        int remaining = Math.abs(N);
        while (remaining > 0) {
            int digit = remaining % 10;
            digits.add(digit);
            remaining = remaining / 10;
        }

        int removeIdx = 0;
        if (N < 0) {
            for (int i = 0; i < digits.size(); i++) {
                if (digits.get(i) == 5) {
                    removeIdx = i;
                    break;
                }
            }
        } else {
            for (int i = digits.size() - 1; i >= 0; i--) {
                if (digits.get(i) == 5) {
                    removeIdx = i;
                    break;
                }
            }
        }

        digits.remove(removeIdx);

        int result = 0;
        int base = 1;
        for (Integer digit : digits) {
            result = result + digit * base;
            base = base * 10;
        }
        return N > 0 ? result : result * (-1);
    }

    public static void main(String[] args) {
        RemoveOptimizedFive removeOptimizedFive = new RemoveOptimizedFive();
        System.out.println(removeOptimizedFive.solution(-5859));
        System.out.println(removeOptimizedFive.solution(15958));
        System.out.println(removeOptimizedFive.solution(-5000));
        System.out.println(removeOptimizedFive.solution(-50));
        System.out.println(removeOptimizedFive.solution(50));
        System.out.println(removeOptimizedFive.solution(-999995));
        System.out.println(removeOptimizedFive.solution(999995));
    }
}
