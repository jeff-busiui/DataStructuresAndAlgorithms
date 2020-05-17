package com.atguigu.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.atguigu.datastructures.util.CommonUtils;

/**
 * 按照一个基数进行调整，把比他小的放到左边，比他大的放到右边，递归完成排序
 *
 * @author sunbaojin
 * @date 2020/5/17 9:19
 */
public class KuaiSuSort {

    public static void main(String[] args) {
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
        int[] zxArr = arr3;
        boolean printFlag = false;

        CommonUtils.printString("排序前,开始时间:" + DateUtil.now());
        // 排序前
        if (printFlag) {
            CommonUtils.printIntOneArray(zxArr);
        }

//        xierSortJiaohuanFunc(zxArr);
        kuaiSuSortFunc(zxArr, 0, zxArr.length - 1);
        CommonUtils.printString("排序后,结束时间:" + DateUtil.now());
        if (printFlag) {
            CommonUtils.printIntOneArray(zxArr);
        }

    }


    /**
     * 按照一个基数进行调整，把比他小的放到左边，比他大的放到右边，递归完成排序
     *
     * @param arry       数值
     * @param leftIndex  左边的下标值
     * @param rightIndex 右边的下标值
     */
    public static void kuaiSuSortFunc(int[] arry, int leftIndex, int rightIndex) {
        int l = leftIndex;
        int r = rightIndex;
        // 记录基数值
        int kValue = arry[(leftIndex + rightIndex) / 2];

        int temp = 0;
        // 说明他们还没找到中间
        while (l < r) {
            // 在kValue的左边找到一个比他大的值
            while (arry[l] < kValue) {
                l++;
            }
            // 在kValue的右边找到一个比他小的值
            while (arry[r] > kValue) {
                r--;
            }
            // 如果l==r了，说明他都找到了kValue所在的下标了，说明左右两边的都是有序的，那就退出
            if (l == r) {
                break;
            }
            // 否则，就进行交换
            temp = arry[l];
            arry[l] = arry[r];
            arry[r] = temp;

            // 交换后，如果 arry[l] 和kValue一样了，说明左边已经到头了，那就移动右边的指针
            if (arry[l] == kValue) {
                r--;
            }

            // 交换后，如果 arry[r] 和kValue一样了，说明右边已经到头了，那就移动左边的指针
            if (arry[r] == kValue) {
                l++;
            }
        }
        // 继续，如果l == r,说明他们在一起了，一定要 进行l ++,r--，否则会栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 左递归
        if (leftIndex < r) {
            kuaiSuSortFunc(arry, leftIndex, r);
        }

        // 右递归
        if (rightIndex > l) {
            kuaiSuSortFunc(arry, l, rightIndex);
        }
    }
}
