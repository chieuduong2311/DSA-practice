package algorithm.week1;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
//    issue 20
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        try {
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    if (map.get(c) != stack.pop()) {
                        return false;
                    }
                } else stack.add(c);
            }
        } catch (EmptyStackException e) {
            return false;
        }
        return stack.empty();
    }
}
