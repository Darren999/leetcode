package com.leetcode.priority_queue;

import java.util.PriorityQueue;

/**
 *
 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 请实现 KthLargest 类：
 KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
public class Leetcode703 {
    public static void main(String[] args){
        int[] numbers = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(2,numbers);
    }
}

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            System.out.println(add(x));
        }
    }

    public int add(int val) {
        pq.offer(val);
        //最小的数字在队列头部，
        if (pq.size() > k) {
            //插入新的元素之后，最小的数字会出列
            pq.poll();
        }
        return pq.peek();
    }
}
