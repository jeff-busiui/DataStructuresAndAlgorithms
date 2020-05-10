package com.atguigu.datastructures.queue;

import com.atguigu.datastructures.CommonUtils;

import java.util.Scanner;

/**
 * 使用数组完成队列
 * 队列特点：
 * 先进先出
 *
 * @author sunbaojin
 * @date 2020/5/10 7:00
 */
public class QueueArrayMain {

    public static void main(String[] args) {
        // 控制台交互
        Scanner scanner = new Scanner(System.in);
        boolean methonFlag = true;

        // 得到用户输入
        while (methonFlag) {
            System.out.println("1(QueueArray),测试普通数组！============");
            System.out.println("2(QueueAnnularArray),测试环形数组！============");
            System.out.println("3(QueueModuolArray),测试环形-取模数组！============");
            System.out.println("e(exit),结束运行！============");

            System.out.println("你要做什么事情?");
            // 得到一个数值
            char charStr = scanner.next().charAt(0);
            switch (charStr) {
                case '1':
                    testQueueArray();
                    break;

                case '2':
                    testAnnularQueueArray();
                    break;
                case '3':
                    testModuolQueueArray();
                    break;
                case 'e':
                    // 得到一个数值
                    CommonUtils.printString("我退出了！");
                    methonFlag = false;
                    break;
                default:
                    break;
            }
        }
        CommonUtils.printString("程序退出了！");
    }

    public static void testQueueArray() {
        // 测试 数值队列
        QueueArray queue = new QueueArray(3);
        runMain(queue);
    }
    public static void testAnnularQueueArray() {
        // 测试 数值队列
        QueueAnnularArray queue = new QueueAnnularArray(3);
        runMain(queue);
    }

    public static void testModuolQueueArray() {
        // 测试 数值队列
        QueueModuolArray queue = new QueueModuolArray(4);
        runMain(queue);
    }

    public static void runMain(QueueInterface queue){

        // 控制台交互
        Scanner scanner = new Scanner(System.in);
        boolean methonFlag = true;

        // 得到用户输入
        while (methonFlag) {
            System.out.println("a(addQueue),向队列增加元素！============");
            System.out.println("r(removeQueue),取出增加元素！============");
            System.out.println("s(showQueue),打印队列元素！============");
            System.out.println("h(headQueue),获取队列头部元素！============");
            System.out.println("e(exit),结束运行！============");

            System.out.println("你要做什么事情?");
            // 得到一个数值
            char charStr = scanner.next().charAt(0);
            switch (charStr) {
                case 'a':
                    System.out.println("请输入一个值：");
                    // 得到一个数值
                    int i = scanner.nextInt();
                    try {
                        queue.addQueue(i);
                    } catch (Exception e) {
                        CommonUtils.printString(e.getMessage());
                    }
                    break;

                case 'r':
                    // 取出一个值
                    int i1 = 0;
                    try {
                        i1 = queue.removeQueue();
                    } catch (Exception e) {
                        CommonUtils.printString(e.getMessage());
                    }
                    System.out.printf("%d\n", i1);
                    break;
                case 's':
                    // 打印数值
                    queue.showQueue();
                    break;
                case 'h':
                    // 得到一个数值
                    int i2 = 0;
                    try {
                        i2 = queue.headQueue();
                    } catch (Exception e) {
                        CommonUtils.printString(e.getMessage());
                    }
                    System.out.printf("头部的数值是：%d\n", i2);
                    break;
                case 'e':
                    // 得到一个数值
                    CommonUtils.printString("我退出了！");
                    methonFlag = false;
                    break;
                default:
                    break;
            }
        }
        CommonUtils.printString("程序退出了！");

    }
}

/**
 * 内部类，完成数组，属性如下
 * 1.maxSize:存储队列的最大容量
 * 2.front:存储队列的队首元素，不存在时，默认为-1；
 * 取出时，front ++
 * 3.rear:存储队列的队尾下标，不存在时，默认为-1；
 * *   增加时，rear ++
 * 4.arry[]:存储队列的元素
 */
class QueueArray  implements QueueInterface{
    private int maxSize;
    private int front;
    private int rear;
    private int arry[];

    /**
     * 根据maxSize构造一个对象
     *
     * @param maxSize
     */
    public QueueArray(int maxSize) {
        this.arry = new int[maxSize];
        this.front = -1;
        this.rear = -1;
        this.maxSize =maxSize;
    }

    /**
     * 判断数组是否满了,思路：
     * 1.老师说 使用 rear == maxSize - 1 来判断是否满，感觉是有问题的，
     * 原因如下：  取出时，front ++；增加时，rear ++；那么rear的值肯定是会超过maxSize的啊
     * 2.个人感觉：应该使用 rear-front == maxSize判断比较合适
     * 3.想了一下，还是按照老师的 rear == maxSize - 1 来判断，可以这样处理：
     * 当取出数据时，发现 front = maxSize -1时，说明最后一个也取出来了，改一下front\rear的值可以吗？
     * 4、听到老师讲解的了，这就是一个一次性数值，不是环形数组，要达到环形数组的效果，要进行处理，如下：
     * 5、个人思路(达到环形数组队列)：
     * 改造方法参考【QueueAnnularArray】
     *
     * @return
     */
    public boolean isFull() {
        //        return rear-front == maxSize;
        return rear == maxSize - 1;
    }


    /**
     * 判断数组是否空了，思路如下：
     * 1.rear -front == 0 时，就可以认为空了
     *
     * @return
     */
    public boolean isEmpty() {
        return rear - front == 0;
    }

    /**
     * 往队列中加入值，思路：
     * 1.rear自增
     */
    public void addQueue(int queueInt) {
        // 判断数组是否满了，满了提示他
        if (isFull()) {
            CommonUtils.printString("我已经满了，请排队等待！");
            return;
        }
        // 数组没满，增加
        this.rear++;
        this.arry[rear] = queueInt;
    }

    /**
     * 取出队列中的值，思路
     */
    public int removeQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            throw new RuntimeException("我已经空了，你可以休息了！");
        }
        this.front++;
        return arry[front];
    }

    /**
     * 打印队列的数据
     */
    public void showQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            System.out.println("我已经空了，你可以休息了！");
        }
        for (int i = 0; i < arry.length; i++) {
            int i1 = arry[i];
            System.out.printf("array[%d]=%d\n", i, arry[i]);
        }
    }

    /**
     * 显示队头数据
     *
     * @return
     */
    public int headQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            throw new RuntimeException("我已经空了，你可以休息了！");
        }
        return arry[front + 1];
    }
}


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
class QueueAnnularArray implements QueueInterface{
    private int maxSize;
    private int rear;
    private int front;
    private int intCount;
    private int arry[];

    /**
     * 根据maxSize构造一个对象
     *
     * @param maxSize
     */
    public QueueAnnularArray(int maxSize) {
        this.arry = new int[maxSize];
        this.intCount = 0;
        this.rear = -1;
        this.front = -1;
        this.maxSize =maxSize;

    }

    /**
     * 个人思路(达到环形数组队列)：
     * 如果intConut = maxSize,认为满了；
     *
     * @return
     */
    public boolean isFull() {
        // 如果intCount = maxSize,认为满了；
        return intCount == maxSize;
    }


    /**
     * 判断数组是否空了，思路如下：
     * 如果intConut = 0 ,认为空了；
     *
     * @return
     */
    public boolean isEmpty() {
        return intCount == 0;
    }

    /**
     * 往队列中加入值，思路：
     * 1.rear自增，如果超过了maxSize -1，那么从0开始计算
     */
    public void addQueue(int queueInt) {
        // 判断数组是否满了，满了提示他
        if (isFull()) {
            CommonUtils.printString("我已经满了，请排队等待！");
            return ;
        }
        // 数组没满，增加
        this.rear++;
        // 如果超过了maxSize -1，那么从0开始计算
        if (rear == maxSize) {
            rear = 0;
        }
        intCount ++;
        this.arry[rear] = queueInt;
    }

    /**
     * 取出队列中的值，思路
     * 1.front自增，如果超过了maxSize -1，那么从0开始计算
     */
    public int removeQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            throw new RuntimeException("我已经空了，你可以休息了！");
        }
        this.front++;
        // 如果超过了maxSize -1，那么从0开始计算
        if (front == maxSize) {
            front = 0;
        }
        intCount --;
        return arry[front];
    }

    /**
     * 打印队列的数据
     */
    public void showQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            System.out.println("我已经空了，你可以休息了！");
        }
        for (int i = 0; i < arry.length; i++) {
            int i1 = arry[i];
            System.out.printf("array[%d]=%d\n", i, arry[i]);
        }
    }

    /**
     * 显示队头数据
     *
     * @return
     */
    public int headQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            throw new RuntimeException("我已经空了，你可以休息了！");
        }
        return arry[front + 1];
    }
}


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
class QueueModuolArray  implements QueueInterface{
    private int maxSize;
    private int front;
    private int rear;
    private int arry[];

    /**
     * 根据maxSize构造一个对象
     *
     * @param maxSize
     */
    public QueueModuolArray(int maxSize) {
        this.arry = new int[maxSize];
        this.front = 0;
        this.rear = 0;
        this.maxSize =maxSize;
    }

    /**
     * 判断数组是否满了,思路：
     * 3、判断满的条件，调整为：  (rear +1) %maxSize == front，说明就是满了
     *
     */
    public boolean isFull() {
        return  (rear+1) % maxSize == front;
    }


    /**
     * 判断数组是否空了，思路如下：
     * 4、判断空的条件，还是：  rear == front，说明就重合了
     *
     * @return
     */
    public boolean isEmpty() {
        return rear - front == 0;
    }

    /**
     * 往队列中加入值，思路：
     * 2.队尾rear含义做个调整：
     *  *   存储的就是下一个将要放进去的元素的下标值，初始值就是0；
     *  *   由于考虑到他一直会自增，所以他对应数组的下标值计算公式为：
     *  *     index = (rear +1) %maxSize
     */
    public void addQueue(int queueInt) {
        // 判断数组是否满了，满了提示他
        if (isFull()) {
            CommonUtils.printString("我已经满了，请排队等待！");
            return;
        }
        // 数组没满，增加，放入数组
        this.arry[rear] = queueInt;
        // 记录下一个下标
        this.rear = (rear+1) % maxSize;

    }

    /**
     * 取出队列中的值，思路
     * 1.队首front含义做个调整：
     *  *   存储的就是当前元素的下标值，即arry[front] 就是当前的值，初始值就是0
     *  *   取出时，所以他对应数组的下标值计算公式为：
     *  *  index =  front %maxSize
     */
    public int removeQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            throw new RuntimeException("我已经空了，你可以休息了！");
        }
        int n =  arry[front];
        front = (front +1)%maxSize;
        return n;
    }

    /**
     * 打印队列的数据
     */
    public void showQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            System.out.println("我已经空了，你可以休息了！");
        }

        System.out.println("===========我当前rear是："+rear);
        System.out.println("===========我当前front是："+front);
        System.out.println("===========我当前有效的数值个数是："+(rear+maxSize-front)%maxSize);
        for (int i = front; i < front + liveSize(); i++) {
            // i%maxSize ：可能出现 front =2,liveSize =3，这样就超过了数值的最大长度，所以取模
            int i1 = arry[i%maxSize];
            System.out.printf("array[%d]=%d\n", i%maxSize, i1);
        }
    }

    /**
     * 显示队头数据
     *
     * @return
     */
    public int headQueue() {
        // 判断数组是否空了，空了提示
        if (isEmpty()) {
            throw new RuntimeException("我已经空了，你可以休息了！");
        }
        return arry[front];
    }

    /**
     * 数组有效的数值
     * @return
     */
    public int liveSize(){
        return  (rear+maxSize-front)%maxSize;
    }
}

interface QueueInterface{

    /**
     * 判断数组是否满了
     *
     * @return
     */
    public boolean isFull();


    /**
     * 判断数组是否空了
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 往队列中加入值，思路：
     */
    public void addQueue(int queueInt);

    /**
     * 取出队列中的值，思路
     */
    public int removeQueue() ;

    /**
     * 打印队列的数据
     */
    public void showQueue() ;

    /**
     * 显示队头数据
     *
     * @return
     */
    public int headQueue();
}