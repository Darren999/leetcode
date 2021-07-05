package com.leetcode;

/** 问题描述：
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点
 * 分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */

/** 题解：（请先参考官网题解，如果已经明白了请跳过）
 *  为什么可以使用双指针的方法来处理？也就是说，为什么左指针可以向右移动，右指针可以向左移动
 *  我们假设左边的值是x，右边的值是y，距离是t。当x<=y，乘积是min(x,y)*t=x*t，那假设左指针不动，右指针逐步移动
 *   t1*x < x*t, 即无论怎么移动，得到的容器容量都要小于之前的容器容量。
 *   既然如此，我们就可以放弃跟当前位置相关的请他情况，即左指针向右移动。右指针向左移动也是相同的道理。
 */
public class Leetcode011 {

    public static int maxArea(int[] nArray) {
        int res = 0;
        int n = nArray.length;
        if(n<=1){
           return res;
        }

        int i = 0;
        int j = n-1;
        while(i<j){
            int height = 0;
            int area = 0;
            if(nArray[i] < nArray[j]){
                height = nArray[i];
                area = (j-i) * height;
                i++;
            }else {
                height = nArray[j];
                area = (j-i) * height;
                j--;
            }

            res = Math.max(res,area);
        }

        return res;
    }

    public static void main(String[] args){
        int[] nArray = new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea(nArray);
        System.out.println("isPalindrome = "+ result);
    }
}
