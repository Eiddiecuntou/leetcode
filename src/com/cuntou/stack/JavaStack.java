package com.cuntou.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName : JavaStack  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/21  17:50
 */

public class JavaStack {
    public static void main(String[] args) {
        //可以使用双端队列 来实现stack
        //使用循环队列实现栈
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        //拿到栈顶元素
        System.out.println(stack.peek());
        stack.isEmpty();
        //判断栈是否为空
        Integer top = stack.pop();

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(2);
        deque.poll();
    }

}
