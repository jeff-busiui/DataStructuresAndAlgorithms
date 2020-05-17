package com.atguigu.datastructures.util;

import java.util.regex.Pattern;

/**
 * 公共方法类
 * @author sunbaojin
 * @date 2020/5/9 23:10
 */
public class CommonUtils {


    /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


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

    /**
     * 打印二维数组
     * @param migongArray
     */
    public static  void printArray(int[][] migongArray){
        for (int i = 0; i < migongArray.length; i++) {
            int[] ints = migongArray[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                System.out.printf("%d\t",anInt);
            }
            // 换行
            System.out.println();
        }
    }

    /**
     * 打印一个一维数组的所有数据
     * @param oneArray
     */
    public static void printIntOneArray(int oneArray[]){
        for (int i = 0; i < oneArray.length; i++) {
            System.out.printf("%d\t" , oneArray[i]);
        }
        // 换行
        System.out.println();
    }
}
