package com.leetcode.stack_queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 */
public class Leetcode20 {

    public static boolean isValid1(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int len = 0;
        do {
            len = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (len != s.length());

        return s.isEmpty();
    }

    public static boolean isValid(String s) {
        int n  = s.length();
        if(n%2 == 1){
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //如果存在，则是右括号；如果不存在表示是左括号
            if (pairs.containsKey(ch)) {
                //栈顶是空，或者栈顶的括号跟map里面的的括号不成对
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{{([])}"));
    }
}
