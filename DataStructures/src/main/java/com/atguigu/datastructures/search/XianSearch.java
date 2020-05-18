package com.atguigu.datastructures.search;

/**
 * 循环数组，找到相同的返回
 * @author sunbaojin
 * @date 2020/5/18 8:48
 */
public class XianSearch {

    public static void main(String[] args) {
        int[] arry = {1,2,9,6,0,5,6,10};
        int i = xianSearchIndex(arry, 10);
        System.out.println("找到的值的下标为："+i);
    }


    public static int xianSearchIndex(int[] arry,int findVal){
        for (int i = 0; i < arry.length; i++) {
            int i1 = arry[i];
            if(i1  == findVal){
                return i;
            }
        }
        return -1;
    }
}
