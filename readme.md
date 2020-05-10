# 数据结构和算法
## 1、稀疏数组[com.atguigu.datastructures.sparseArray]
* 完成11*11的数值转化为稀疏数组
```java
 /**
         * 转换为稀疏数组,思路：
         * 1.获取有效数值的个数sum
         * 2.创建一个int[sum+1][3]
         * 3.int[0]:存储 数值行数、列数、有效数值个数
         * 4.int[x]:存储有效数值的所在行、所在列，及其有效值
         */
```
* 完成稀疏数组转化为11*11原始数组
```java
        /**
         * 稀疏数组转换为原始数组思路
         * 1.根据稀疏数组的第一行获取行、列，创建数值
         * 2.从1开始循环，设置数值的值
         */
```
* 完成稀疏数组写入到本地磁盘文件
* 完成本地磁盘文件转化为稀疏数组
```java
 /**
         *写入磁盘思路
         * 1.将稀疏数组转化为 json字符串，存入文件
         * 2.读取文件，转化为稀疏数组
         * 3.将稀疏数组转化为原始数组
         */
```
*  总结：如果二维数组的总个数/3 > 二维数组的有效值个数，就不应该转换为稀疏数组了，
           因为 二维数组的有效值个数*3后，就会大于二维数组的总个数! 

## 2、队列-数组实现队列[com.atguigu.datastructures.QueueArrayMain]
* 完成固定位数的数组 com.atguigu.datastructures.QueueArray
* 按照自己的想法完成的环形数组 com.atguigu.datastructures.QueueAnnularArray
* 按照老师的取模思路完成的环形数组 com.atguigu.datastructures.QueueModuolArray
* 总结： 刚开始自己比较懵，还是需要多学习！！！有些地方还是想不明白！