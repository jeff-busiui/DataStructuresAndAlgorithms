package com.atguigu.datastructures.recursion;

import com.atguigu.datastructures.util.CommonUtils;

/**
 * @author sunbaojin
 * @date 2020/5/14 12:18
 */
public class MigongTest {

    public static void main(String[] args) {

        /**
         * 定义一个迷宫
         * 值约定如下：
         *   0 代表没走过
         *   1 代表墙
         *   2 代表走过的路
         *   3 表示从此路出发无法走到终点
         *
         * 走路的约定如下：
         *    下->右->上->左
         *
         */
        int[][] migongArray = new int[10][10];
        // 设置上下左右都是强
        for (int i = 0; i <= 9; i++) {
            migongArray[0][i] = 1;
            migongArray[9][i] = 1;
            migongArray[i][0] = 1;
            migongArray[i][9] = 1;
        }
        // 再加两个墙
//        migongArray[2][2] = 1;
        migongArray[3][1] = 1;
        migongArray[3][2] = 1;
        // 打印一下迷宫
        CommonUtils.printArray(migongArray);
        // 从,1,1开始走
        setWay(migongArray,1,1);
        System.out.println("=================走过之后的迷宫========================");
        // 打印一下走后的数组
        CommonUtils.printArray(migongArray);
    }
    


    /**
     * 招找一条到终点的路
     * 值约定如下：
     *          *   0 代表没走过
     *              1 代表墙
     *          *   2 代表走过的路
     *          *   3 表示从此路出发无法走到终点
     *          *
     *          * 走路的约定如下：
     *          *    下->右->上->左
     *  终点：migongArray[8][8]
     * @param migongArray
     * @param i
     * @param j
     */
    public static boolean setWay(int[][] migongArray,int i,int j){
        if(i == 8 && j == 8){
            return  true;
        }
        else{
            // 如果是0，那么可以走
            if(migongArray[i][j] ==0){
                // 默认揍他
                migongArray[i][j] =2 ;
                // 向下走,走通
                if(setWay(migongArray,i+1,j)){
                    return true;
                }
                // 向下走,走不通，那就向右走
                else if(setWay(migongArray,i,j+1)){
                    return true;
                }
                // 走不通，那就向上走
                else if(setWay(migongArray,i-1,j)){
                    return true;
                }
                // 走不通，那就向左走
                else if(setWay(migongArray,i,j-1)){
                    return true;
                }
                // 那就走不通
                else{
                    migongArray[i][j] =3 ;
                    return false;
                }
            }
            // 如果是 1，说明是墙，走不通了
            // 如果是 2，说明是走过了，走不通了
            // 如果是 3，说明是走过但没走通，走不通了，都返回false
            else {
                return false;
            }
        }

    }
}

