package com.leetcode;

import java.util.HashSet;
import java.util.Set;


/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

public class Leetcode003 {

//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        // 记录当前滑动窗口内部的重复元素
//        int[] freq = new int[256];
//        int l = 0;
//        int r = 0;
//        int res = 0;
//        while(l < n){
//            if(r < n && freq[s.charAt(r)]==0){
//                // 当前没有重复元素，移动右边界
//                freq[s.charAt(r++)]++;
//            }else{
//                // 存在重复元素，移动左边界
//                freq[s.charAt(l++)]--;
//            }
//            // 记录所有满足条件的子数组的长度
//            res = Math.max(res, r-l);
//        }
//        return res;
//    }


    private static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();
        int l = 0;
        int r = 0;
        int res = 0;
        int n = s.length();
        while (r < n){
            if(!occ.contains(s.charAt(r))){
                occ.add(s.charAt(r));
                r++;
            }else{
                occ.remove(s.charAt(l));
                l++;
            }

            res = Math.max(res,r-l);
        }

        return res;
    }

    public static void main(String[] args){
        int len = lengthOfLongestSubstring("abcabcbbabcde");
        System.out.println("len = "+len);
    }
}
