package com.atguigu.datastructures.huisu;

/**
 * 8皇后问题：
 * 递归需要遵守的重要规则
 * <p>
 * 执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
 * 方法的局部变量是独立的，不会相互影响, 比如n变量
 * 如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据.
 * 递归必须向退出递归的条件逼近，否则就是无限递归,出现StackOverflowError，死龟了:)
 * 当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。
 * <p>
 * 八皇后问题介绍
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：在8×8
 * 格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *
 * @author sunbaojin
 * @date 2020/5/16 8:13
 */
public class Huanghou8Main {


    // 最多8个棋子
    int max = 8;
    //  由于期盼是8行行列，第1个棋子只能放第1行、第2个棋子只能放第2行、所以 只需要记住8个棋子的下标就行
    int[] huanghou = new int[8];

    // 记录一共执行的次数
    private static int countCishu = 0;

    // 记录一共满足的解法
    private static int countFangfa = 0;

    public static void main(String[] args) {
        Huanghou8Main huanghou8Main = new Huanghou8Main();
        // 执行
        huanghou8Main.checkWeizhi(0);
        System.out.printf("一共执行了%d次\n",countCishu);
        System.out.printf("一共有%d次解法\n",countFangfa);
    }

    /**
     * 检查当前位置是否可以放
     * * 任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
     *
     * @param n 代表当前是第
     */
    public void checkWeizhi(int n) {
        // 说明已经放了max个了，就打印出数值
        if (n == max) {
            countFangfa++;
            printArray();
            return;
        }
        // 不满足，那就继续循环
        for (int i = 0; i < max; i++) {
            // 先放到第1列，再放第2列、、、、、以此类推
            huanghou[n] = i;
            // 判断是否和 【同一行、同一列或同一斜线上】有重复
            // 有冲突，那就 把棋子往下一个位置放;
            // 没有冲突，那就 放下一个棋子
            if(isChongtu(n)){
                checkWeizhi(n+1);
            }

        }
    }


    /**
     * 判断当前放的行数和他之前已存在的是否重复
     * @param n 当前第几个皇后
     * @return
     */
    public boolean  isChongtu(int n) {

        countCishu ++ ;
        // 只需要和之前已经放好的比较就可以了
        for (int i = 0; i < n; i++) {

            // 判断是否和 【同一行、同一列或同一斜线上】有重复
            // huanghou[n] == huanghou[i] 代表他们在同一行了
            if(huanghou[n] == huanghou[i]){
               return false;
            }
            // 同一斜线上: 向左的斜线
            else if((huanghou[n] - huanghou[i]) == n-i){
                return false;
            }
            // 同一斜线上: 向右的斜线
            else if((huanghou[i] - huanghou[n]) == n-i){
                return false;
            }

        }
        return true;
    }

    public void printArray() {
        // 说明已经放了max个了，就打印出数值
        for (int i = 0; i < huanghou.length; i++) {
            int i1 = huanghou[i];
            System.out.printf("%d\t",i1);
        }
        System.out.println();

    }

}


