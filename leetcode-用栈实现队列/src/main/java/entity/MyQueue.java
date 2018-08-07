package entity;

import java.util.Stack;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 11:56
 */
public class MyQueue {

    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(Integer x) {
        if (x == null) {
            return;
        }
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public Integer pop() {
        Integer[] o = new Integer[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            o[i] = pop;
            i++;
        }
        Integer res = o[i - 1];
        for (int i1 = o.length - 2; i1 >= 0; i1--) {
            push(o[i1]);
        }
        return res;
    }

    /**
     * Get the front element.
     */
    public Integer peek() {
        Integer[] o = new Integer[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            o[i] = pop;
            i++;
        }
        Integer res = o[i - 1];
        for (int i1 = o.length - 1; i1 >= 0; i1--) {
            push(o[i1]);
        }
        return res;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        Object peek = myQueue.peek();
        Object pop = myQueue.pop();
        boolean empty = myQueue.empty();

        System.out.println(peek);
        System.out.println(pop);
        System.out.println(empty);
    }
}
