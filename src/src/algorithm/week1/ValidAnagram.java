package algorithm.week1;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
//    issue 242
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//        Map<Character, Integer> countMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            countMap.merge(s.charAt(i), 1, Integer::sum);
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            Integer value = countMap.get(t.charAt(i));
//            if (value == null || value == 0) {
//                return false;
//            }
//            countMap.put(t.charAt(i), value - 1);
//        }
//
//        return true;

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            countMap.putIfAbsent(s.charAt(i), 0);
            countMap.compute(s.charAt(i), (k,v) -> ++v);

            countMap.putIfAbsent(t.charAt(i), 0);
            countMap.compute(t.charAt(i), (k,v) -> --v);

        }

        for (Integer count : countMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        var s = "anagram";
        var t = "nagaram";

        System.out.println(validAnagram.isAnagram(s, t));
    }
}
