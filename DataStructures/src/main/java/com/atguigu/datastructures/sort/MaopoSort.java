package com.atguigu.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.atguigu.datastructures.util.CommonUtils;

/**
 * 冒泡排序
 * 1.时间复杂度o(n^2)
 * 2.排序时，拿本次的数和前一次进行比较，如果大于前一次，进行互换
 * @author sunbaojin
 * @date 2020/5/16 19:52
 */
public class MaopoSort {

    public static void main(String[] args) {

        int numSize = 8000000;
        // 创建一个数值
        int[] arr1 = {11,2,3,8,5,9};
        int[] arr2 = {2,2,3,6,7,8};
        int[] arr3 = new int[numSize];
        // 生成随机数
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) (Math.random()*numSize);
        }

        // 要执行的数值
        int[] zxArr = arr3;

        CommonUtils.printString("排序前,开始时间:"+ DateUtil.now());
        // 排序前
//        CommonUtils.printIntOneArray(zxArr);
        maopoSortFunc(zxArr);
        CommonUtils.printString("排序后,结束时间:"+ DateUtil.now());
//        CommonUtils.printIntOneArray(zxArr);
    }
    
    public static void maopoSortFunc(int[] arry){
        int count = 0;
        // 循环对比
        for (int i = 0; i < arry.length; i++) {
//            CommonUtils.printString("当前是第【"+(i+1)+"】次执行");
            int i1 = arry[i];
            // 记录本次循环有没有发生变更
            boolean falg =false;
            // 循环比较 ，拿本次的数和前一次进行比较，如果大于前一次，进行互换
            // 从1开始比较
            for (int j = 1; j < arry.length; j++) {
                int num1 = arry[j];
                // 开始比较
                if(num1 < arry[j-1]){
                    // 换位置
                    arry[j] = arry[j-1];
                    arry[j-1]=num1;
                    falg = true;
                }
                count ++ ;
            }
            // 如果没有发送变更，就退出
            if(!falg){
                break;
            }
        }

        CommonUtils.printString("执行的次数为:"+count);
    }

}
