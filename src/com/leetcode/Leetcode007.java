package com.leetcode;

/**
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。\n
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。\n
 */
public class Leetcode007 {

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if ((result < Integer.MIN_VALUE / 10) ||
                    (result > Integer.MAX_VALUE / 10)) {
                return 0;
            }

            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
