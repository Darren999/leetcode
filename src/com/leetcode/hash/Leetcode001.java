package com.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Leetcode001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int val = target-nums[i];
            if(map.containsKey(val)){
                return new int[]{map.get(val),i};
            }else{
                map.put(nums[i],i);
            }
        }

        return null;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
