package algorithm.week3;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
//    issue 3
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        int current = 0;
        HashMap<Character, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            if (idxMap.get(s.charAt(i)) == null) {
                count++;
            } else if (idxMap.get(s.charAt(i)) >= current) {
                count = i - idxMap.get(s.charAt(i));
                current = idxMap.get(s.charAt(i)) + 1;
            } else {
                count++;
            }
            idxMap.put(s.charAt(i), i);

            if (max < count) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aab";
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(s));
    }
}
