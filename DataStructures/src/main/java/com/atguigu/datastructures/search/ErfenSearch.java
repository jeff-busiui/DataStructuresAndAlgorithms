package com.atguigu.datastructures.search;

/**
 *
 * 1.数值必须有序的
 * 2.先找数值下标为中间的值，和要查找的值进行比较
 * 3.查找的值 》 中间的值，那就向右递归查找
 * 4.查找的值 < 中间的值，那就向左递归查找
 * 5.查找的值 == 中间的值，那就直接返回
 * @author sunbaojin
 * @date 2020/5/18 8:51
 */
public class ErfenSearch {

    public static void main(String[] args) {
        int[] arry = {1,2,9,6,0,5,6,10};
        int i = erfenSearch(arry, 0,arry.length-1,6);
        System.out.println("找到的值的下标为："+i);
    }

    /**
     *  * 1.数值必须有序的
     *  * 2.先找数值下标为中间的值，和要查找的值进行比较
     *  * 3.查找的值 》 中间的值，那就向右递归查找
     *  * 4.查找的值 < 中间的值，那就向左递归查找
     *  * 5.查找的值 == 中间的值，那就直接返回
     * @param arry 要查找的数值
     * @param left 左侧下标
     * @param right 右侧下标
     * @param findVal 要查找的值
     * @return 查找到的值
     */
    public static int erfenSearch(int[] arry,int left,int right,int findVal){
        // 如果left大于right，说明没找到
        if(left>right){
            return  -1;
        }
        // 计算中间的下标
        int mind = (left+right)/2;
        int mindValue = arry[mind];
        // 循环查找
        // 查找的值 》 中间的值，那就向右递归查找
        if(findVal > mindValue){
            // 向右递归
            return erfenSearch(arry,mind+1,right,findVal);
        }
        // 查找的值 < 中间的值，那就向左递归查找
        else if(findVal < mindValue){
            // 向右递归
            return erfenSearch(arry,left,mind-1,findVal);
        }
        // 查找的值 == 中间的值，那就直接返回
        else {
            // 向右递归
            return mind;
        }
    }
}
