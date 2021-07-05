package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 */
public class Leetcode015 {

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        int n = nums.length;
//        Arrays.sort(nums); // 排序
//
//        if ((n < 3) ||
//                //all smaller than 0 or all bigger than 0
//                (nums[n - 1] < 0 && nums[0] > 0)) {
//            return ans;
//        }
//        int L = 0;
//        int R = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//            if(i>=1 && nums[i]==nums[i-1]){
//                continue;
//            }
//
//            L = i + 1;
//            R = n - 1;
//            while (L < R) {
//                int sum = nums[i] + nums[L] + nums[R];
//                if (sum == 0) {
//                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
//                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
//                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
//                    L++;
//                    R--;
//                } else if (sum < 0) {
//                    L++;
//                } else {
//                    R--;
//                }
//            }
//        }
//
//        return ans;
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        //数据进行排序
        Arrays.sort(nums);
        //最小的数都大于零，那么结果必定大于零；最大的数都小于零，那么结果必定小于零
        if (n < 3 || nums[0]>0 || nums[n-1]<0) {
            return ans;
        }

        int L = 0;
        int R = 0;
        for (int i = 0; i < n; i++) {
            //数据排序之后，如果最左边的数都大于零，那么右边的数可定也大于零
            if (nums[i] > 0) {
                break;
            }

            //去重，如果当前的数跟前面一个数相同，那就要去掉
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            L = i+1;
            R = n-1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L ++;//左指针去重
                    while (L < R && nums[R] == nums[R-1]) R--;//右指针去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {1, 0, -1};
        List<List<Integer>> results = threeSum(nums);

        System.out.println("results = " + results.toString());
    }
}
