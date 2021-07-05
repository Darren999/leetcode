package com.leetcode.array_link;

/**
 * 问题描述：
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class Leetcode24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /**
         * 为什么要有dummNode，因为指针操作之后，头指针会变化
         */
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curr = dummyNode;

        //每次往前移动两个位置，如果不满足，则表示结束
        while (curr.next != null && curr.next.next != null) {
            //头结点下第一个节点
            ListNode node1 = curr.next;
            //头结点下第二个节点
            ListNode node2 = curr.next.next;

            //第二个节点变成第一个节点，先将node1.next存起来，直接赋值给curr.next,否则下面的操作会被覆盖
            curr.next = node2;

            //第二个节点的子节点变成第一个节点的子节点
            node1.next = node2.next;
            //第一个节点变成第二个节点的子节点
            node2.next = node1;

            //指针往前移动：需注意这里用的不是node1.next ，这里用的是dummy head
            curr = node1;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode testListNode = ListNode.createTestListNode(1, 2, 3, 4,5,6);
        ListNode res = swapPairs(testListNode);
        System.out.println(res.toString());
    }
}
