package com.leetcode.array_link;

/**
 * 题目描述：
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class Leetcode206 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            //先将next存起来，否则curr.next会被覆盖
            ListNode next = curr.next;

            //当前节点指向前面的节点
            curr.next = prev;

            //下次循环：prev指针往后移动
            prev = curr;
            //下次循环：curr指针往后移动
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args){
        ListNode testNode = ListNode.createTestListNode(2,3,4,5);
        System.out.println(reverseList(testNode).toString());
    }
}

