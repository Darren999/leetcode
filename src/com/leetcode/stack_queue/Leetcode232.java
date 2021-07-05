package com.leetcode.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 *请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class Leetcode232 {
    public static void main(String[] args){
         MyQueue myQueue = new MyQueue();
        myQueue.push(11);
        myQueue.push(22);
        System.out.println("pop = " + myQueue.pop());
        System.out.println("peek = " + myQueue.peek());
        System.out.println("empty = "+ myQueue.empty());
    }
}

class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }

        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }

        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
