package com.atguigu.datastructures.recursion;

import com.atguigu.datastructures.util.CommonUtils;

/**
 * @author sunbaojin
 * @date 2020/5/14 12:48
 */
public class ShuDuUtil {
    public static void main(String[] args)  {
        try {
            new ShuDu(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 数独的定义
 * 1.数独的阶数： x阶 ,可填数字范围 1~x，宫格2阶
 * 2.数独的取值范围[1-9]
 *     4 阶：可填数字范围 1~4，宫格2阶
 *
 * 　　9 阶：可填数字范围 1~9，宫格3阶
 *
 * 　　16 阶：可填数字范围 1~16，宫格4阶
 */
class  ShuDu{
    /**
     * 1.数独的阶数： 表示7行7列
     */
    private int shuDuSize;

    /**
     * 数独的长度计算
     * 行： =
     */
    private int[][] shuDuArray;


    /**
     * 最大的值，默认是1
     */
    private int maxInt;


    /**
     * 最小的值，默认是1
     */
    private int minInt = 1;
    public   ShuDu(int shuDuSize) throws Exception{

        // 计算行列，对 shuDuSize开平方，为正数，说明可以生成
//        double sqrt = Math.sqrt(shuDuSize);
//        // 如果不是正数抛出异常
//        // 得到阶数
//

        this.shuDuSize = shuDuSize;
        this.maxInt = shuDuSize;
        // 数组的大小
        this.shuDuArray = new int[shuDuSize][shuDuSize];
        CommonUtils.printArray(shuDuArray);
    }


}
