package com.leetcode.array_link;

/**
 * 问题描述：
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 */
public class Leetcode142 {

    public static ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode res = detectCycle(node1);
        if(res == null){
            System.out.println("null");
        }else{
            System.out.println(res.val);
        }
    }
}
