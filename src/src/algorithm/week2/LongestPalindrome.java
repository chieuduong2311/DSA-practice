package algorithm.week2;

public class LongestPalindrome {
//    issue 409
    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] count = new int[52];
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) >= 97) {
                count[s.charAt(i) - 'a' + 26]++;
            } else count[s.charAt(i) - 'A']++;
        }

        boolean hasOdd = false;
        int total = 0;
        for (int c : count) {
            if (c % 2 == 0) {
                total += c;
                continue;
            }
            hasOdd = true;
            total += c - 1;
        }
        return hasOdd ? total + 1 : total;
    }
}
