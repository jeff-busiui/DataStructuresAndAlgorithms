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
```java
/**
 * 内部类，完成数组，属性如下
 * 1.maxSize:存储队列的最大容量
 * 2.front:存储队列的队首元素，不存在时，默认为-1；
 * 取出时，front ++
 * 3.rear:存储队列的队尾下标，不存在时，默认为-1；
 * *   增加时，rear ++
 * 4.arry[]:存储队列的元素
 */
```
* 按照自己的想法完成的环形数组 com.atguigu.datastructures.QueueAnnularArray
```java

/**
 * 个人思路(达到环形数组队列)：
 * 1) 判断数组是否满了/空了，思路如下：增加一个变量intCount，记录当前元素个数，
 * 如果intConut ==maxSize,认为满了；
 * 如果intConut == 0 ,认为空了；
 * 2）队尾rear:记录当前插入的节点的下标到哪了
 * 3) 队首front：记录当前取出的节点的下标到哪了
 * 3）增加一个当前下标的值nowIndex：记录队首
 * 4)改造方法参考【QueueAnnularArray】
 */
```
* 按照老师的取模思路完成的环形数组 com.atguigu.datastructures.QueueModuolArray
```java
/**
 * 用取模的思路进行解题：
 * 1.队首front含义做个调整：
 *   存储的就是当前元素的下标值，即arry[front] 就是当前的值，初始值就是0
 *   取出时，所以他对应数组的下标值计算公式为：
 *  index =  front %maxSize
 * 2.队尾rear含义做个调整：
 *   存储的就是下一个将要放进去的元素的下标值，初始值就是0；
 *   由于考虑到他一直会自增，所以他对应数组的下标值计算公式为：
 *     index = (rear +1) %maxSize
 * 3、判断满的条件，调整为：  (rear +1) %maxSize == front，说明就是满了
 * 4、判断空的条件，还是：  rear == front，说明就重合了
 * 5、判断有效个数：(rear + 1 - front)%maxSize  有效数组的个数肯定不会超过数组的长度！
 *
 * 重要：有个约定空间得概念，所以存储的最大元素数量为maxSzie -1
 *
 */
```
* 总结： 刚开始自己比较懵，还是需要多学习！！！有些地方还是想不明白！

## 3、链表
* 1.简单的无序列表[com.atguigu.datastructures.linkedlist.SimpleLinkedListMain]
    链表特点：包括2个区域、a、data域 b、next域
    一个头部根节点，插入时一定要找到最后一个节点的next为空，插入
* 2.单向链表的增删改查、反转、合并操作