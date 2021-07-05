package com.leetcode.priority_queue;

import java.util.*;

public class Leetcode239 {

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            /**
             * 巧妙的设计之处：优先队列的元素不是单一的数组元素，而是数组元素和下标i
             * 这样做的好处是：数组元素用于比较元素大小，下标用于poll出优先队列
             */
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        /**
         * 1）双头队列设计，最大的数放在前面，最小的数放在后面,这里保存的不是数组元素的值，而是小标，这样做的好处
         * 是滑动的时候，可以根据小标出列
         * 2）1, 3, -1：1 比后面的3 小，且生命周期比1小，没必要保留；而 -1 虽然比3小，但是生命周期比3大，虽然要保留
         */
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        //取出最大的值
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            //新的元素比前面的数值大，那么前面的值都出列
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //插入新的元素
            deque.offerLast(i);
            //最大的元素生命周期到了，需要出列
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = new int[]{ 1,-1};
        int[] result = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }
}
