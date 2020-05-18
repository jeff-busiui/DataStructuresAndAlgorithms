package com.atguigu.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.atguigu.datastructures.util.CommonUtils;

/**
 * 归并排序的思想：
 * 1.先分后合
 * 2.使用递归，先把数值分组最小的颗粒度，然后再递归的方法内，分组合并进行排序
 * 3.最后再把合并好的数值进行封装到新的数值中
 *
 * @author sunbaojin
 * @date 2020/5/17 22:37
 */
public class GuibingSort {

    public static void main(String[] args) {
        int[] arry = {8, 29, 8, 10, 2, 6, 9, 8, 5};

        int numSize = 8000000;
        // 创建一个数值
        int[] arr1 = {11, 2, 3, 8, 5, 9};
        int[] arr2 = {2, 2, 3, 6, 7, 8};
        int[] arr3 = new int[numSize];

        int[] arr4 = {2, 9, 8, 7, 5, 10, 7, 6, 9, 2, 3, 6, 7, 8};
        // 生成随机数
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) (Math.random() * numSize);
        }

        // 要执行的数值
        int[] zxArr = arry;
        boolean printFlag = true;

        CommonUtils.printString("排序前,开始时间:" + DateUtil.now());
        // 排序前
        if (printFlag) {
            CommonUtils.printIntOneArray(zxArr);
        }
        // 临时数值，存储排好序的数值元素,长度和原始数据一致
        int[] temp = new int[zxArr.length];
        fenArry(zxArr, 0, zxArr.length - 1, temp);
        CommonUtils.printString("排序后,结束时间:" + DateUtil.now());
        if (printFlag) {
            CommonUtils.printIntOneArray(zxArr);
        }

    }

    /**
     * 使用递归把数据先进行分，在进行合
     *
     * @param arry  要排序的数据
     * @param left  左边的开始下标
     * @param right 右边的开始下标
     * @param temp  临时数组
     */
    public static void fenArry(int[] arry, int left, int right, int[] temp) {
        // 递归推出规则： 从左开始 -》》从右开始，他们进行合并了
        if (left < right) {
            // 获取 中间的数组
            int mind = (left + right) / 2;
            // 从左侧开始递归，进行分合,左侧开始，mind结束
            fenArry(arry, left, mind, temp);
            // 从右侧开始递归，进行分合,mind+1开始，right结束
            fenArry(arry, mind + 1, right, temp);

            // 合并的真正方法，由于递归调用时，像栈一样，先进去的后弹出来，所以可以完成
            bingArry(arry,left,mind,right,temp);
        }
    }

    /**
     * 使用递归把数据先进行分，在进行合
     *
     * @param arry  要排序的数据
     * @param left  左边的开始下标
     * @param mind  左边和右边慢慢的向 mind  靠近
     * @param right 右边的开始下标
     * @param temp  临时数组
     */
    public static void bingArry(int[] arry, int left, int mind, int right, int[] temp) {

        // 左侧开始，找到mind
        int i = left;
        // 右侧开始，从mind+1找到right
        int j = mind + 1;
        int k = 0;
        // 判断下，如果left > right,就可以结束了
        // 左边的大于右边的，就换位置
        // 临时变量
        int indexValue = 0;
        // 一个是假的，那就都是假的，所以，只要任何一个循环完了，就结束循环
        while (i <= mind && j <= right) {

            // 左侧的位置 < 右侧的位置，交换位置
            if (arry[i] <= arry[j]) {
                indexValue = arry[i];
                // 左侧的比右侧的小，那就把 左侧的值赋值给 temp
                i++;
                // 把值给临时数值
                temp[k] = indexValue;
                // k向后移动一位，为下次做准备
                k++;
            }
            // 说明右侧的小，那就赋值给temp，右侧的就后移
            else {
                indexValue = arry[j];
                // 左侧的比右侧的大，那就把 右侧的值赋值给 temp
                j++;
                // 把值给临时数值
                temp[k] = indexValue;
                // k向后移动一位，为下次做准备
                k++;
            }
        }
        // 循环完成后，如果发现i 还没到mind,那就把i-mind的值给temp
        while (i <= mind) {
            temp[k] = arry[i];
            i++;
            k++;
        }
        // 循环完成后，如果发现j 还没到right,那就把j-right的值给temp
        while (j <= right) {
            temp[k] = arry[j];
            j++;
            k++;
        }


        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        k = 0;
        // 从left开始，到right结束
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arry[tempLeft] = temp[k];
            k++;
            tempLeft++;
        }
    }
}
