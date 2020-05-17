package com.atguigu.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.atguigu.datastructures.util.CommonUtils;

import java.util.Arrays;

/**
 * 希尔排序：
 * 希尔排序法介绍
 * <p>
 * 希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
 * <p>
 * 希尔排序法基本思想
 * <p>
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 *
 * @author sunbaojin
 * @date 2020/5/17 6:03
 */
public class XierSort {


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
        xierSortInsertFunc(zxArr);
        shellSort2(zxArr);
        CommonUtils.printString("排序后,结束时间:" + DateUtil.now());
        if (printFlag) {
            CommonUtils.printIntOneArray(zxArr);
        }

    }

    /**
     * 希尔排序法应用实例:
     * <p>
     * 有一群小牛, 考试成绩分别是 {8,9,1,7,2,3,5,4,6,0} 请从小到大排序. 请分别使用
     * 希尔排序时， 对有序序列在插入时采用交换法, 并测试排序速度.
     * 希尔排序时， 对有序序列在插入时采用移动法, 并测试排序速度
     */
    public static void xierSortJiaohuanFunc(int[] arry) {
        // 数组的长度
        int arryLength = arry.length;
        // 定义初始分组变量
        int groupSize = arryLength / 2;
        // 如果不是1，那就继续循环
        while (groupSize > 0) {
            // 对数组进行排序，交换
            // 要拿前半部分的值i和i+groupSize的值进行比较
            for (int i = groupSize; i < arryLength; i++) {
                // 进行插入排序
                for (int j = i - groupSize; j >= 0; j -= groupSize) {
                    int i3 = arry[j];
                    int i4 = arry[j + groupSize];
                    // 后面的小于前面的，交换位置
                    if (i3 > i4) {
                        //换位置
                        arry[j] = i4;
                        arry[j + groupSize] = i3;
                    }
                }
            }
//            System.out.println("执行后的排序结果为："+ Arrays.toString(arry));
            groupSize = groupSize / 2;
        }
    }

    /**
     * 希尔排序法应用实例:
     * <p>
     * 有一群小牛, 考试成绩分别是 {8,9,1,7,2,3,5,4,6,0} 请从小到大排序. 请分别使用
     * 希尔排序时， 对有序序列在插入时采用交换法, 并测试排序速度.
     * 希尔排序时， 对有序序列在插入时采用移动法, 并测试排序速度
     */
    public static void xierSortInsertFunc(int[] arry) {
        // 数组的长度
        int arryLength = arry.length;
        // 定义初始分组变量
        int groupSize = arryLength / 2;
        // 如果不是1，那就继续循环
        while (groupSize > 0) {
            // 对数组进行排序，交换
            // 要拿前半部分的值i和i+groupSize的值进行比较
            for (int i = groupSize; i < arryLength; i++) {
                // 记录当前下标
                int k = i;
                int kValue = arry[k];
                // 进行比较
                if (arry[k] < arry[k - groupSize]) {
                    // 进行插入排序
//                    for (int j = k - groupSize; j >= 0; j -= groupSize) {
//                        arry[k] = arry[k-groupSize];
//                    }
                    while (k - groupSize >= 0 && kValue < arry[k - groupSize]) {
                        // 换位置
                        arry[k] = arry[k - groupSize];
                        k-=groupSize;
                    }
                    arry[k] = kValue;
                }
            }
//            System.out.println("执行后的排序结果为："+ Arrays.toString(arry));
            groupSize = groupSize / 2;
        }
    }


    // 使用逐步推导的方式来编写希尔排序
    // 希尔排序时， 对有序序列在插入时采用交换法,
    // 思路(算法) ===> 代码
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0;
        // 根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }

		/*

		// 希尔排序的第1轮排序
		// 因为第1轮排序，是将10个数据分成了 5组
		for (int i = 5; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
			for (int j = i - 5; j >= 0; j -= 5) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j + 5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}

		System.out.println("希尔排序1轮后=" + Arrays.toString(arr));//


		// 希尔排序的第2轮排序
		// 因为第2轮排序，是将10个数据分成了 5/2 = 2组
		for (int i = 2; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
			for (int j = i - 2; j >= 0; j -= 2) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j + 2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}

		System.out.println("希尔排序2轮后=" + Arrays.toString(arr));//

		// 希尔排序的第3轮排序
		// 因为第3轮排序，是将10个数据分成了 2/2 = 1组
		for (int i = 1; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
			for (int j = i - 1; j >= 0; j -= 1) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println("希尔排序3轮后=" + Arrays.toString(arr));//
		*/
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }

}
