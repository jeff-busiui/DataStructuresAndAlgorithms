package com.atguigu.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.atguigu.datastructures.util.CommonUtils;

/**
 * 插入排序：
 * 1.把数据看做2部分，1部分有序、1部分无序
 * 2.每次都拿无序的部分的值 和有序的比，小于的插入到前面，大于的插入到后面
 * @author sunbaojin
 * @date 2020/5/16 20:51
 */
public class InsertSort {


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
        insertSortFunc(zxArr);
        CommonUtils.printString("排序后,结束时间:"+ DateUtil.now());
//        CommonUtils.printIntOneArray(zxArr);
    }

    public static void insertSortFunc(int[] arry){
        // 循环，从1开始，默认第一个数值就是有序的
        for (int i = 1; i < arry.length; i++) {
            int i1 = arry[i];
            // 记录当前比较的下标之前，有序的最大的下标
            // 那 i-1之前的值和当前值比较 进行比较
            for (int j = i-1; j >= 0 ;  j--) {
                int i2 = arry[j];
                // 当前的值，如果小于有序数值，
                //那么就把优先序号的下标后移一位
                if( i1 < i2){
                    // 将他后一个进行移动
                    arry[j+1] = arry[j];
                    arry[j] = i1;
                }
            }
        }
    }
}
