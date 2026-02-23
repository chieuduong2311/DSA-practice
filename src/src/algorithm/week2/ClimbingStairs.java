package algorithm.week2;

public class ClimbingStairs {
//    issue 70
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int n1 = 2, n2 = 3, n3 = 0;
        for (int i = 4; i <= n ; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}
