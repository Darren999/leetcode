package com.leetcode;

public class Leetcode009 {

    public static boolean isPalindrome (int x) {

        String origin = String.valueOf(x);
        String revert = new StringBuilder(origin).reverse().toString();

        return origin.equals(revert);
    }

    public static void main(String[] args){
        boolean result = isPalindrome(1233221);
        System.out.println("isPalindrome = "+ result);
    }
}
