package com.atguigu.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.atguigu.datastructures.util.CommonUtils;

import java.util.Arrays;

/**
 * 基数排序(桶排序)介绍:
 * <p>
 * 基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，顾名思义，它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
 * <p>
 * 基数排序法是属于稳定性的排序，基数排序法的是效率高的稳定性排序法
 * <p>
 * 基数排序(Radix Sort)是桶排序的扩展
 * <p>
 * 基数排序是1887年赫尔曼·何乐礼发明的。它是这样实现的：将整数按位数切割成不同的数字，然后按每个位数分别比较。
 *
 * @author sunbaojin
 * @date 2020/5/18 8:06
 */
public class JishuSort {

    public static void main(String[] args) {
        int[] arry = {8, 29, 8, 10, 2, 6, 9, 8, 5};

        int numSize = 8000000;
        // 创建一个数值
        int[] arr1 = {11, 2, 3, 8, 5, 9};
        int[] arr2 = {2, 2, 3, 6, 7, 8};
        int[] arr3 = new int[numSize];

        int[] arr4 = {2, 92, 81, 712, 51, 10, 7, 116, 921, 21, 3, 61, 7, 80};
        // 生成随机数
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) (Math.random() * numSize);
        }

        // 要执行的数值
        int[] zxArr = arr4;
        boolean printFlag = true;

        CommonUtils.printString("排序前,开始时间:" + DateUtil.now());
        // 排序前
        if (printFlag) {
            CommonUtils.printIntOneArray(zxArr);
        }
        jishuSortGood(zxArr, 3);
        CommonUtils.printString("排序后,结束时间:" + DateUtil.now());
        if (printFlag) {
            CommonUtils.printIntOneArray(zxArr);
        }

    }

    /**
     * 基数排序基本思想
     * <p>
     * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     * <p>
     * 这样说明，比较难理解，下面我们看一个图文解释，理解基数排序的步骤
     *
     * @param arry 要排序的数值
     */
    public static void jishuSort(int[] arry) {

        // 定义10个桶,存放一维数组的值，由于不确认每个桶的大小，所以给arry.length长度
        int[][] tongArray = new int[10][arry.length];

        // 记录10个桶放入的元素个数
        int[] countSzie = new int[10];

        // 第1轮，按照个位数的值放入到不同的桶中
        // 循环数组，获取 数字内 个位数为的值，依次放入桶中
        for (int i = 0; i < arry.length; i++) {
            int i1 = arry[i];
            // 获取个位数的值
            int gwValue = i1 % 10;
            // 依次放入到桶中
            tongArray[gwValue][countSzie[gwValue]] = i1;
            countSzie[gwValue]++;
        }
        // 记录新的数值的下标
        int k = 0;
        // 循环桶，把值给原来的值
        for (int i = 0; i < tongArray.length; i++) {
            int[] i1 = tongArray[i];
            // 获取桶中是否有数据,没数据，就继续下一个
            if (countSzie[i] == 0) {
                continue;
            } else {
                for (int j = 0; j < countSzie[i]; j++) {
                    arry[k] = i1[j];
                    k++;
                }
            }
        }
        System.out.println("第1次排序后的数组为：" + Arrays.toString(arry));
        // 记录10个桶放入的元素个数
        countSzie = new int[10];

        // 第2轮，按照个位数的值放入到不同的桶中
        // 循环数组，获取 数字内 十位数为的值，依次放入桶中
        for (int i = 0; i < arry.length; i++) {
            int i1 = arry[i];
            // 获取个位数的值
            int gwValue = i1 / 10 % 10;
            // 依次放入到桶中
            tongArray[gwValue][countSzie[gwValue]] = i1;
            countSzie[gwValue]++;
        }

        // 记录新的数值的下标
        k = 0;
        // 循环桶，把值给原来的值
        for (int i = 0; i < tongArray.length; i++) {
            int[] i1 = tongArray[i];
            // 获取桶中是否有数据
            if (countSzie[i] == 0) {
                continue;
            } else {
                for (int j = 0; j < countSzie[i]; j++) {
                    arry[k] = i1[j];
                    k++;
                }
            }
        }

        System.out.println("第2次排序后的数组为：" + Arrays.toString(arry));

        // 记录10个桶放入的元素个数
        countSzie = new int[10];

        // 第3轮，按照个位数的值放入到不同的桶中
        // 循环数组，获取 数字内 百位数为的值，依次放入桶中
        for (int i = 0; i < arry.length; i++) {
            int i1 = arry[i];
            // 获取个位数的值
            int gwValue = i1 / 100 % 10;
            // 依次放入到桶中
            tongArray[gwValue][countSzie[gwValue]] = i1;
            countSzie[gwValue]++;
        }

        // 记录新的数值的下标
        k = 0;
        // 循环桶，把值给原来的值
        for (int i = 0; i < tongArray.length; i++) {
            int[] i1 = tongArray[i];
            // 获取桶中是否有数据
            if (countSzie[i] == 0) {
                continue;
            } else {
                for (int j = 0; j < countSzie[i]; j++) {
                    arry[k] = i1[j];
                    k++;
                }
            }
        }
        System.out.println("第3次排序后的数组为：" + Arrays.toString(arry));
    }

    /**
     * 对基数排序进行代码优化
     *
     * @param arry      要排序的数组
     * @param numWeishu 数字最大的位数
     */
    public static void jishuSortGood(int[] arry, int numWeishu) {

        // 定义10个桶,存放一维数组的值，由于不确认每个桶的大小，所以给arry.length长度
        int[][] tongArray = new int[10][arry.length];

        // 记录10个桶放入的元素个数
        int[] countSzie = null;

        /**
         * 数字最大的位数是几位，那就循环几次，进行桶排序
         *
         */
        for (int h = 1; h <= numWeishu; h++) {
            countSzie = new int[10];
            // 记录新的数值的下标
            int k = 0;
            // 计算当前要排序的位数,10的 h-1次方
            int nowWs = (int) Math.pow(10, h - 1);
            // 第1轮，按照个位数的值放入到不同的桶中
            // 循环数组，获取 数字内 个位数为的值，依次放入桶中
            for (int i = 0; i < arry.length; i++) {
                int i1 = arry[i];
                // 获取个位数的值
                int gwValue = i1 / nowWs % 10;
                // 依次放入到桶中
                tongArray[gwValue][countSzie[gwValue]] = i1;
                countSzie[gwValue]++;
            }

            // 循环桶，把值给原来的值
            for (int i = 0; i < tongArray.length; i++) {
                int[] i1 = tongArray[i];
                // 获取桶中是否有数据,没数据，就继续下一个
                if (countSzie[i] == 0) {
                    continue;
                } else {
                    for (int j = 0; j < countSzie[i]; j++) {
                        arry[k] = i1[j];
                        k++;
                    }
                }
            }
            System.out.println("第1次排序后的数组为：" + Arrays.toString(arry));

        }
    }
}
