package com.leetcode.array_link;

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }

   @Override
   public String toString() {
      ListNode curr = this;
      StringBuilder stringBuilder = new StringBuilder();
      while (curr != null) {
         stringBuilder.append(curr.val).append(" ");
         curr = curr.next;
      }
      return stringBuilder.toString();
   }


   public static ListNode createTestListNode(int... args){
      ListNode dummyHead = new ListNode(0);
      ListNode cur = dummyHead;

      for(int i=0; i<args.length; i++){
         cur.next = new ListNode(args[i]);
         cur = cur.next;
      }

      return dummyHead.next;
   }
}
