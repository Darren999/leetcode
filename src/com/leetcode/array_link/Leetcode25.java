package com.leetcode.array_link;

/**
 * 问题描述:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Leetcode25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while(head != null){
            ListNode tail = pre;
            for (int i=0; i<k; i++){
                tail = tail.next;
                if(tail == null){
                    return dummyHead.next;
                }
            }

            //先把尾节点的下个节点存起来
            ListNode next = tail.next;

            //取出翻转后的节点
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = next;

            //移动指针
            pre = tail;
            head = tail.next;
        }

        return dummyHead.next;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public static ListNode[] reverseList(ListNode head,ListNode tail) {
        //最后一个节点要成为head的子节点
        ListNode prev = tail.next;
        ListNode curr = head;
        //为什么不是 (curr!=tail)?，prev和curr相差一个位置，
        // 当curr = tail时，tail节点还没有跟前面一个节点完成倒序就退出了
        while (prev != tail) {
            //先将next存起来，否则curr.next会被覆盖
            ListNode next = curr.next;

            //当前节点指向前面的节点
            curr.next = prev;

            //下次循环：prev指针往下一个节点移动
            prev = curr;
            //下次循环：curr指针往下一个节点移动
            curr = next;
        }

        return new ListNode[]{tail,head};
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.createTestListNode(1,2,3,4,5);

        System.out.println(reverseKGroup(node1,5).toString());
    }
}
