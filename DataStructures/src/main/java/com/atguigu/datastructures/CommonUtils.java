package com.atguigu.datastructures;

/**
 * 公共方法类
 * @author sunbaojin
 * @date 2020/5/9 23:10
 */
public class CommonUtils {


    /**
     * 打印一个二维数组的所有数据
     * @param twoArray
     */
    public static void printIntTwoArray(int twoArray[][]){
        for (int i = 0; i < twoArray.length; i++) {
            for (int data : twoArray[i]) {
                System.out.printf("%d\t" , data);
            }
            System.out.println();
        }
    }

    /**
     * 打印前后带===============的字符串
     * @param printStr
     */
    public static void printString(String printStr){
        System.out.println("================"+printStr+"===================");
    }
}
