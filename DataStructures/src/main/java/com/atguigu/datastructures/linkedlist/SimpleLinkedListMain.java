package com.atguigu.datastructures.linkedlist;

/**
 * 简单的单项链表的练习
 *
 * @author sunbaojin
 * @date 2020/5/10 19:57
 */
public class SimpleLinkedListMain {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "武松", "打虎英雄");
        // 加入链表
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add(heroNode1);
        simpleLinkedList.add(heroNode3);
        simpleLinkedList.add(heroNode4);
        simpleLinkedList.add(heroNode2);
        // 打印
        simpleLinkedList.printList();
    }

}

/**
 * 一个单项链表
 */
class SimpleLinkedList {
    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * 头部节点，不保存具体数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode newHeroNode) {
        // 临时变量，当前根节点
        HeroNode temp = head;
        // 获取当前链表的最后一个节点的值
        while (true) {
            // 如果当前链表的next是最后一个，那就把新的节点加进去
            if (temp.next == null) {
                // 赋值
                temp.next = newHeroNode;
                // 跳出循环
                break;
            }
            // 否则，继续下一个节点的值
            temp = temp.next;
        }
    }

    /**
     * 按照顺序进行添加，思路如下：
     * 1、一个临时变量temp，记录当前操作的节点的值
     * 2、从head遍历，做如下判断：
     * head.next == null : 说明是第一个插入的元素，可以插入,找到了,退出循环
     * head.next.no > newHeroNode.no：说明下一个节点的编号 比新加的大,找到了,退出循环
     * head.next.no = newHeroNode.no：说明新加的no已存在,找到了,退出循环
     * 3、已存在no，不让插入；否则，执行4
     * 4、  newHeroNode.next = temp.next;
     * temp.next = newHeroNode
     *
     * @param newHeroNode
     */
    public void addOrderHero(HeroNode newHeroNode) {
        // 临时变量，当前根节点
        HeroNode temp = head;
        // 默认false，不重复
        boolean flag = false;
        // 获取当前链表的最后一个节点的值
        while (true) {
            // head.next == null : 说明是第一个插入的元素，可以插入,找到了,退出循环
            if (temp.next == null) {
                // 跳出循环
                break;
            }
            // head.next.no > newHeroNode.no：说明下一个节点的编号 比新加的大,,找到了,退出循环
            else if (temp.next.no > newHeroNode.no) {
                // 跳出循环
                break;
            }
            // head.next.no = newHeroNode.no：说明新加的no已存在,找到了,退出循环
            else if (temp.next.no == newHeroNode.no) {
                // 跳出循环
                flag = true;
                break;
            }
            // 否则，继续下一个节点的值
            temp = temp.next;
        }
        // 判断是否重复
        if (flag) {
            System.out.println("=============【" + newHeroNode.no + "】已经重复了,不允许插入！！");
        } else {
            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
        }
    }


    /**
     * 修改节点的值，思路：
     * 1.记录当前节点的临时变量temp
     * 2.比较一下temp.next.no == updateHeroNode.no,相等，执行3
     * 3.修改:
     * updateHeroNode.next = temp.next.next
     * temp.next = updateHeroNode
     * 根据no找到节点，记录到临时编号，然后改一下他的属性值
     *
     * @param updateHeroNode
     */
    public void updateHero(HeroNode updateHeroNode) {
        // 临时变量，当前根节点
        HeroNode temp = head;
        boolean flag = false;
        // 获取当前链表的最后一个节点的值
        while (true) {
            // 没数据了，退出
            if (temp.next == null) {
                break;
            } else if (temp.next.no == updateHeroNode.no) {
                // 跳出循环
                flag =true;
                break;
            }
            // 否则，继续下一个节点的值
            temp = temp.next;
        }
        // 找到了， 修改:
        //     * updateHeroNode.next = temp.next.next
        //     * temp.next = updateHeroNode
        if(flag){
            updateHeroNode.next = temp.next.next;
            temp.next = updateHeroNode;
        }

    }


    /**
     * 删除节点的思路：
     *  1.记录当前节点的临时变量temp
     *  2.比较一下temp.next.no == updateHeroNode.no,相等，执行3
     *  3.修改:
     *     temp.next = temp.next.next;
     * @param deleteHero
     */
    public void deleteHero(HeroNode deleteHero) {
        // 临时变量，当前根节点
        HeroNode temp = head;
        boolean flag = false;
        // 获取当前链表的最后一个节点的值
        while (true) {
            // 没数据了，退出
            if (temp.next == null) {
                break;
            } else if (temp.next.no == deleteHero.no) {
                // 跳出循环
                flag =true;
                break;
            }
            // 否则，继续下一个节点的值
            temp = temp.next;
        }
        // 找到了， 删除
        if(flag){
            temp.next = temp.next.next;
        }

    }

    /**
     * 打印链表
     */
    public void printList() {
        // 获取临时变量
        HeroNode temp = head.next;
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
 * 一个node的节点
 */
class HeroNode {
    // 编号
    public int no;
    // 姓名
    public String name;
    // 昵称
    public String nickName;
    // 下一个域
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
