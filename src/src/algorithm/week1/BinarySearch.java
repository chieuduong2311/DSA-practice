package algorithm.week1;

public class BinarySearch {
    //    issue 704
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int result = (end - start + 1) / 2;
        while (start < end) {
            if (nums[result] == target) {
                return result;
            } else if (nums[result] > target) {
                end = result - 1;
                result = (end - start + 1) / 2;
            } else {
                start = result + 1;
                result = result + (end - start + 1) / 2;
            }
        }
        if (nums[end] == target) {
            return end;
        } else return -1;
    }
}
