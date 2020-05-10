package com.atguigu.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单的单项链表的练习
 * @author sunbaojin
 * @date 2020/5/10 19:57
 */
public class SimpleSortLinkedListMain {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"武松","打虎英雄");
        // 加入链表
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
//        simpleLinkedList.add(heroNode1);
//        simpleLinkedList.add(heroNode3);
//        simpleLinkedList.add(heroNode4);
//        simpleLinkedList.add(heroNode2);

        simpleLinkedList.addOrderHero(heroNode1);
        simpleLinkedList.addOrderHero(heroNode3);
        simpleLinkedList.addOrderHero(heroNode4);
        simpleLinkedList.addOrderHero(heroNode2);
        simpleLinkedList.addOrderHero(heroNode4);
        simpleLinkedList.addOrderHero(heroNode2);
        // 打印
        simpleLinkedList.printList();
        System.out.println("==================执行修改======================");
        // 修改一下
        HeroNode heroNode5 = new HeroNode(2,"孙保金","寨主");
        simpleLinkedList.updateHero(heroNode5);
        // 打印
        simpleLinkedList.printList();

        System.out.println("==================执行删除======================");
        // 修改一下
        HeroNode heroNode6 = new HeroNode(3,"孙保金","寨主");
//        simpleLinkedList.deleteHero(heroNode6);
//        simpleLinkedList.deleteHero(heroNode1);
        // 打印
        simpleLinkedList.printList();
        // 打印长度
        System.out.println("============当前链表的长度为："+getNodeLength(simpleLinkedList.getHead()));

        // 获取倒数第k个节点
        System.out.println("============倒数第k个节点为："+getKNdoe(simpleLinkedList.getHead(),1));
        System.out.println("==================反转链表======================");
        reversalNdoe(simpleLinkedList.getHead(),simpleLinkedList);
        // 打印
        simpleLinkedList.printList();
        System.out.println("==================倒序打印链表======================");
        printInvertedLinked(simpleLinkedList.getHead());

    }

    /**
     * 求单链表中有效节点的个数，思路：
     *  1、遍历链表，获取所有的数据
     *  2、由于有个head节点，所有此节点不统计
     * @param heroNode
     * @return
     */
    public static int getNodeLength(HeroNode heroNode){
        int nodeLength = 0;
        // 临时
        while (true){
            // 说明时最后一个了，退出
            if(heroNode.next == null){
                break;
            }
            nodeLength ++;
            // 移动到下一个节点
            heroNode = heroNode.next;
        }
        return nodeLength;
    }

    /**
     * 查找单链表中的倒数第k个结点 【新浪面试题】，思路：
     *  1、遍历链表，获取所有的数据,及其节点的个数nodeLenght
     *  2、倒数第k个结点 公式： nodeLenght - k
     * @param heroNode
     * @return
     */
    public static HeroNode getKNdoe(HeroNode heroNode,int k){
        int nodeLength = getNodeLength(heroNode);
        // 如果没长度，或长度超过了链表长度，提示异常
        if(nodeLength == 0 || nodeLength < k){
            System.out.println("========我没这么多元素！！！==========");
            return null;
        }
        // 记录k的值
        int index = nodeLength-k;
        // 临时数值
        int nowIndex = 0;
        // 结果值
        HeroNode resultNode ;
        // 临时
        while (true){
            // 说明时最后一个了，退出
            if(nowIndex == index){
                resultNode = heroNode.next;
                break;
            }
            nowIndex ++;
            // 移动到下一个节点
            heroNode = heroNode.next;
        }
        return resultNode;
    }

    /**
     * 单链表的反转【腾讯面试题，有点难度】，思路：
     *  1、遍历链表，获取所有的数据,放到一个list中
     *  2、倒序循环list，改动
     *      head.next =list.get(i);
     *      list.get(i).next =list.get(i-1);
     *
     * @param heroNode
     * @return
     */
    public static void reversalNdoe(HeroNode heroNode,SimpleLinkedList simpleLinkedList){

        // 记录根节点

        List<HeroNode> heroNodeList = new ArrayList<>();
        // 临时
        while (true){
            // 说明时最后一个了，退出
            if(heroNode.next == null){
                break;
            }
            // 加入list
            heroNodeList.add(heroNode.next);
            // 移动到下一个节点
            heroNode = heroNode.next;
        }

        HeroNode rootHead  = simpleLinkedList.getHead();
        // 改动下原链接的值
        for (int i = heroNodeList.size() -1; i >= 0 ; i--) {
            HeroNode node =  heroNodeList.get(i);
            // 改动值
            rootHead.next = node;

            // 如果是最后一个，改为null
            if(i == 0){
                node.next = null;
                break;
            }
            else{
                node.next = heroNodeList.get(i-1);
            }
            rootHead =rootHead.next;
        }
    }


    /**
     * 从尾到头打印单链表 【百度，要求方式1：反向遍历 。 方式2：Stack栈】，思路：
     *  1、遍历链表，获取所有的数据,放到一个list中
     *  2、倒序循环list，打印数值
     *
     * @param heroNode
     * @return
     */
    public static void printInvertedLinked (HeroNode heroNode){

        // 记录根节点

        List<HeroNode> heroNodeList = new ArrayList<>();
        // 临时
        while (true){
            // 说明时最后一个了，退出
            if(heroNode.next == null){
                break;
            }
            // 加入list
            heroNodeList.add(heroNode.next);
            // 移动到下一个节点
            heroNode = heroNode.next;
        }
        // 改动下原链接的值
        for (int i = heroNodeList.size() -1; i >= 0 ; i--) {
            HeroNode node =  heroNodeList.get(i);
            System.out.println(node);
        }
    }

}
