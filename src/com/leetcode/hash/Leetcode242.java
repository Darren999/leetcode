package com.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode242 {

    public static boolean isAnagram1(String s, String t) {

        int nS = s.length();
        int nT = t.length();
        if(nS != nT){
            return false;
        }

        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i=0; i<nT; i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }

        return sMap.equals(tMap);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        String sSort = sortString(s);
        String tSort = sortString(t);
        return sSort.equals(tSort);
    }

    private static String sortString(String s){
        char[] ar = s.toCharArray();
        Arrays.sort(ar);

        return String.valueOf(ar);
    }

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
