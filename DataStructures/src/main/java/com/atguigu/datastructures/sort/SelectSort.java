package com.atguigu.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.atguigu.datastructures.util.CommonUtils;

/**
 * 选择排序
 * 基本介绍
 * 选择式排序也属于内部排序法，是从欲排序的数据中，按指定的规则选出某一元素，再依规定交换位置后达到排序的目的。
 * @author sunbaojin
 * @date 2020/5/16 20:24
 */
public class SelectSort {

    public static void main(String[] args) {
        // 创建一个数值
        int[] arr1 = {11,2,3,8,5,9};
        int[] arr2 = {2,2,3,6,7,8};
        int[] arr3 = new int[80000];
        // 生成随机数
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) (Math.random()*80000);
        }

        // 要执行的数值
        int[] zxArr = arr3;

        CommonUtils.printString("排序前,开始时间:"+ DateUtil.now());
        // 排序前
//        CommonUtils.printIntOneArray(zxArr);
        selectSortFunc(zxArr);
        CommonUtils.printString("排序后,结束时间:"+ DateUtil.now());
//        CommonUtils.printIntOneArray(zxArr);
    }

    public static void selectSortFunc(int[] arry){
        // 循环，每次都取最小的数据，赋值给 下标0\1\2\3... n-1
        for (int i = 0; i < arry.length; i++) {
            // 记录当前元素为最小的值
            int minValue = arry[i];
            // 下标
            int minIndex = i;
            // 获取最小的值，从i+1开始，因为i=1之前的都是排好序的
            for (int j = i+1; j < arry.length; j++) {
                int value1 = arry[j];
                // 避免自己和自己比
                if(value1 < minValue ){
                    // 记录下标和值
                    minValue = value1;
                    minIndex = j;
                }
            }
            // 赋值给arr[i]
            arry[minIndex] = arry[i];
            arry[i] = minValue;
        }
    }
}
