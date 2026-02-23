package algorithm.week2;

public class MajorityElement {
//    issue 169
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] == element) {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
            } else {
                element = nums[i];
                count = 1;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1};
        System.out.println(majorityElement.majorityElement(nums));
    }
}
