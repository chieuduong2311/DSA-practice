package algorithm.week2;

public class FirstBadVersion {
//    issue 278
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
    
    boolean isBadVersion(int version) {
        return version >= 9;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(10));
    }

}
