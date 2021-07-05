package com.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class Leetcode013 {

    public static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String str){
        int len = str.length();
        int result = 0;
        for(int i=0; i<len; i++){
            int value = symbolValues.get(str.charAt(i));
            if(i< len-1 && value < symbolValues.get(str.charAt(i+1))){
                result -= value;
            }else{
                result += value;
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(romanToInt("MCMXCIV"));
    }
}
