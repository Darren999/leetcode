package com.leetcode;

import java.util.Arrays;

public class Leetcode016 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int L = i + 1, R = n - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                if (sum > target) {
                    // 如果和大于 target，移动 R 对应的指针
                    while (L < R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    R--;
                } else {
                    // 如果和小于 target，移动 L 对应的指针
                    while (L < R && nums[L] == nums[L+1]) {
                        L++;
                    }
                    L++;
                }
            }
        }
        return best;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{1,1,-1,-1,3};
        System.out.println(threeSumClosest(numbers,-1));
    }
}
