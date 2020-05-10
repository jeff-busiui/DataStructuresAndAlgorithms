package com.atguigu.datastructures.linkedlist;

import java.util.Stack;

/**
 * @author sunbaojin
 * @date 2020/5/10 23:05
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("11111");
        stack.add("22222");
        stack.add("33333");
        // 打印
        while (!stack.empty()) {
            //查询栈顶的元素，不删除
            System.out.println(stack.peek());
            //查询栈顶的元素，删除
            System.out.println(stack.pop());

        }
    }
}
