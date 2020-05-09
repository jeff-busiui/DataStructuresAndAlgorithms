package com.atguigu.datastructures;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏数组
 * 五子棋作为例子
 *
 * @author sunbaojin
 * @date 2020/5/9 22:31
 */
public class sparseArray {

    public static void main(String[] args) throws Exception {
        // 创建一个原始数组 11*11 ， 0：无棋子 1：黑棋 2:蓝棋
        int oldArray[][] = new int[11][11];
        // 第一个 是黑棋
        oldArray[1][2] = 1;
        oldArray[2][3] = 2;
        // 打印数组
        System.out.println("=======================我是原始数组=============================");
        CommonUtils.printIntTwoArray(oldArray);

        /**
         * 转换为稀疏数组,思路：
         * 1.获取有效数值的个数sum
         * 2.创建一个int[sum+1][3]
         * 3.int[0]:存储 数值行数、列数、有效数值个数
         * 4.int[x]:存储有效数值的所在行、所在列，及其有效值
         */
        // 总数
        int sum = 0;
        // 放一个一维数组，存有效值信息
        List<int[]> validDataList = new ArrayList<>();
        for (int i = 0; i < oldArray.length; i++) {
            for (int j = 0; j < oldArray[i].length; j++) {
                int data = oldArray[i][j];
                // 如果不是0,那就是有效数值，计数+1，并存储位数
                if (data != 0) {
                    // 总数+1，并记录数值对象
                    sum++;
                    int dataArray[] = new int[3];
                    // 行数
                    dataArray[0] = i;
                    // 列数
                    dataArray[1] = j;
                    // 数值
                    dataArray[2] = data;
                    // 加入list
                    validDataList.add(dataArray);
                }
            }
        }
        // 创建数值
        int sparseArray[][] = new int[sum + 1][3];
        // 存储 第一行数据
        sparseArray[0][0] = oldArray.length;
        sparseArray[0][1] = oldArray[0].length;
        sparseArray[0][2] = sum;
        // 存储数组数据,从1开始
        for (int i = 1; i < sparseArray.length; i++) {
            sparseArray[i] = validDataList.get(i - 1);
        }
        // 打印数值
        System.out.println("=======================我是原始数组转化的稀疏数组=============================");
        CommonUtils.printIntTwoArray(sparseArray);
        System.out.println("=======================我是稀疏数组转化的原始数组=============================");
        /**
         * 稀疏数组转换为原始数组思路
         * 1.根据稀疏数组的第一行获取行、列，创建数值
         * 2.从1开始循环，设置数值的值
         */
        // 1.根据稀疏数组的第一行获取行、列，创建数值
        int newDataArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 2.从1开始循环，设置数值的值
        for (int i = 1; i < sparseArray.length; i++) {
            // 设置值
            newDataArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 打印数值
        CommonUtils.printIntTwoArray(newDataArray);

        System.out.println("=======================我是稀疏数组写入磁盘=============================");
        /**
         *写入磁盘思路
         * 1.将稀疏数组转化为 json字符串，存入文件
         * 2.读取文件，转化为稀疏数组
         * 3.将稀疏数组转化为原始数组
         */
        // 1.将稀疏数组转化为 json字符串，存入文件

        OutputStream out = new FileOutputStream("d:/sparseArray.json");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
        // 写文件
        outputStreamWriter.write(JSONUtil.toJsonStr(sparseArray));
        outputStreamWriter.close();
        out.close();

        System.out.println("=======================我是磁盘写入稀疏数组=============================");
        // 2.读取文件，转化为稀疏数组
        FileReader fileReader = new FileReader("d:/sparseArray.json");
        // 得到数据
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuffer stringBuffer = new StringBuffer();

        String bufferString = "";
        // 得到数据
        while ((bufferString = bufferedReader.readLine()) != null) {
            stringBuffer.append(bufferString);
        }
        bufferedReader.close();
        fileReader.close();
        // 打印字符串
        System.out.println(stringBuffer.toString());
        // 3.将稀疏数组转化为原始数组
        JSONArray jSONArray = JSONUtil.parseArray(stringBuffer.toString());
        int newSparseArray[][] = new int[jSONArray.size()][3];
        // 得到二维数组
        for (int i = 0; i < jSONArray.size(); i++) {
            // 获取数据
            // 继续转化为数据
            JSONArray jSONObjArray = (JSONArray) jSONArray.get(i);
            // 获取数据
            for (int j = 0; j < jSONObjArray.size(); j++) {
                newSparseArray[i][j] = (int) jSONObjArray.get(j);
            }
        }
        // 打印数值
        CommonUtils.printIntTwoArray(newSparseArray);

    }
}
