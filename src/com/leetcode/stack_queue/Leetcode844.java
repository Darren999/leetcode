package com.leetcode.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**问题描述：
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class Leetcode844 {
    public static boolean backspaceCompare(String s, String t) {
        String resS = backspace(s);
        String resT = backspace(t);

        return resS.equals(resT);
    }

    public static String backspace(String s) {
        int n  = s.length();
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args){
//        System.out.println(backspaceCompare("ab#c","ad#c"));
//        System.out.println(backspaceCompare("ab##","c#d#"));
        System.out.println(backspaceCompare("y#fo##f","y#f#o##f"));
    }
}
