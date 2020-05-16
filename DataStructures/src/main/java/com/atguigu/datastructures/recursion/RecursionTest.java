package com.atguigu.datastructures.recursion;

/**
 * @author sunbaojin
 * @date 2020/5/12 12:49
 */
public class RecursionTest {
    public static void main(String[] args) {
        // 测试一下
        int  result = test(4);
        System.out.println("我真的结束了！"+result);
    }

    public static int test(int n) {
        // 结果
        int result = 0;
        if(n>1){
            System.out.printf("%d\n",n);
            result = test(n-1);
        }
        // 打印
        System.out.println("我结束了！"+result);
        return result;
    }
}
