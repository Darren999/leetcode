package com.leetcode;

class   Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] twoNums = new int[2];
        int i = 0;
        int j = 0;
        for(i=0; i<nums.length; i++){
            for(j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    twoNums[0] = i;
                    twoNums[1] = j;
                    return twoNums;
                }
            }
        }

        return twoNums;
    }

    public ListNode addTwoNumbers(ListNode listNode1,ListNode listNode2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode p1 = listNode1;
        ListNode p2 = listNode2;
        int carry = 0;

        while(p1!= null || p2!=null){
            int x1 = (p1 != null)?  p1.val : 0;
            int x2 = (p2 != null)? p2.val : 0;

            int sum = x1 + x2 + carry;
            carry = sum/10;

            cur.next = new ListNode(sum%10);
            cur = cur.next;

            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
        }

        if(carry>0){
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public ListNode createTestListNode(int... args){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        for(int i=0; i<args.length; i++){
            cur.next = new ListNode(args[i]);
            cur = cur.next;
        }

        return dummyHead.next;
    }



    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode listNode1 = solution.createTestListNode(9);
        ListNode listNode2 = solution.createTestListNode(1,9,9,9,9,9,9,9,9,9);

        ListNode result = solution.addTwoNumbers(listNode1,listNode2);
        ListNode tmp = result;
        while (tmp!= null){
            System.out.println(" "+tmp.val);
            tmp = tmp.next;
        }
    }
}