package algorithm.week1;

public class ValidPalindrome {

//    issue 125
    public boolean isPalindrome(String s) {
        int front = 0, back = s.length() - 1;
        while (front <= back) {
            if (!Character.isLetterOrDigit(s.charAt(front))) {
                front++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(back))) {
                back--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(back))) {
                return false;
            } else {
                front++;
                back--;
            }
        }
        return true;
    }
}
