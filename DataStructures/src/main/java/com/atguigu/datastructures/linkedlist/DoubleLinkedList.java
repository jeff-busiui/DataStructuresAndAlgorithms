package com.atguigu.datastructures.linkedlist;

/**
 * 双向链表的练习
 *
 * @author sunbaojin
 * @date 2020/5/11 12:33
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        // 测试新增
        testAdd();
    }

    public static void testAdd() {
        DoubleLindedList doubleLindedList = new DoubleLindedList();
        // 添加节点
        HeroNodeDouble heroNode1 = new HeroNodeDouble(1, "宋江", "及时雨");
        HeroNodeDouble heroNode2 = new HeroNodeDouble(2, "卢俊义", "玉麒麟");
        HeroNodeDouble heroNode3 = new HeroNodeDouble(3, "吴用", "智多星");
        HeroNodeDouble heroNode4 = new HeroNodeDouble(4, "武松", "打虎英雄");
        doubleLindedList.addNode(heroNode1);
        doubleLindedList.addNode(heroNode2);
        doubleLindedList.addNode(heroNode3);
        doubleLindedList.addNode(heroNode4);

        doubleLindedList.printList();
    }
}


class DoubleLindedList {
    // 根节点
    public HeroNodeDouble heroNodeDouble = new HeroNodeDouble(0, "", "");
    // 添加节点

    public void addNode(HeroNodeDouble newheroNodeDouble) {
        // 临时编号
        HeroNodeDouble temp = heroNodeDouble;

        System.out.println("========================add 开始================================");
        // 存储节点
        while (true) {
            // 找到最后一个next为空的节点
            if (temp.next == null) {
                // 添加到节点中，新增的是他的子节点
                temp.next = newheroNodeDouble;
                // 他是新增的父节点
                newheroNodeDouble.pre = temp;
                break;
            }
            // 没结束，继续找
            temp = temp.next;
        }
        System.out.println("========================add 完成================================");
    }

    /**
     * 打印链表
     */
    public void printList() {
        // 获取临时变量
        HeroNodeDouble temp = heroNodeDouble.next;
        while (true) {
            // 如果当前链表的next是最后一个，那就把新的节点加进去
            if (temp == null) {
                // 跳出循环
                break;
            }
            // 打印参数
            System.out.println(temp.toString());
            // 否则，继续下一个节点的值
            temp = temp.next;
        }
    }
}

/**
 * 双向链表的节点
 */
class HeroNodeDouble {
    // 编号
    public int no;
    // 姓名
    public String name;
    // 昵称
    public String nickName;
    // 下一个域
    public HeroNodeDouble next;
    // 上一个域
    public HeroNodeDouble pre;

    public HeroNodeDouble(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNodeDouble{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}