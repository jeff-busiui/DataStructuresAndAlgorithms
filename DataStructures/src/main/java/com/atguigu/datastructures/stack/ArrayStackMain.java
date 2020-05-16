package com.atguigu.datastructures.stack;

/**
 * @author sunbaojin
 * @date 2020/5/11 21:09
 */
public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        // 进
        arrayStack.addStack(1);
        arrayStack.addStack(2);
        arrayStack.addStack(3);
        arrayStack.addStack(4);
        arrayStack.addStack(5);
        arrayStack.addStack(6);
        // 出
        arrayStack.popStack();
        arrayStack.popStack();
        arrayStack.popStack();
        arrayStack.popStack();
        arrayStack.popStack();
        arrayStack.popStack();
    }
}

class ArrayStack{
    // 栈的最大大小
    private int maxSzie;
    // 存储栈的数组
    private int[] stackArr;
    // 栈的元素
    private int top = -1;

    public ArrayStack(int maxSzie) {
        this.maxSzie = maxSzie;
        stackArr = new int[maxSzie];
    }

    /**
     * 进栈
     * @param a
     */
    public void addStack(int a){
        if(top >= maxSzie -1){
            System.out.println("栈已经满了======================");
            return;
        }
        stackArr[++top] = a;
    }

    /**
     * 出栈
     */
    public void popStack(){
        if(top <= -1 ){
            System.out.println("栈已经空了======================");
            return;
        }
        int obj = stackArr[top--];
        System.out.println("我出来了======="+obj);
    }
}
