package Crack.Chp8.Excercise;

import Crack.Chp8.MyLinkNode;

/**
 * Created by Tong on 2017/2/10.
 */

/*
* 实现算法:
* 移除未排序链表中的重复节点,且不能使用临时缓冲区
*
* 思路:这里的链表,因为提到了排序的问题,所以认为是存储整数或是浮点型数的链表。
* 若不使用临时缓冲区,则可以和数组一样的使用hash方法
*
* 这里不允许使用临时缓冲区
*
* 暴力法:使用两个指针指向链表,通过循环比较两个指针所指的值来看是否有重复。这种方法复杂度应该是n的平方
*
* 递归思路:从第1个节点开始,查看后面n-1的子链表是否存在这个值,如果存在,则删除此节点,如果不存在则看下一个节点
*
* */

public class Excercise2_1 {
    public static void main(String[] args){
        MyLinkNode<Integer> linkList = new MyLinkNode();
        MyLinkNode<Integer> pointer = linkList;

        Integer[] intArray = {1,3,2,2,2,3};

        for (Integer integer : intArray){
            if (linkList.appendToTail(integer)){}else{
                continue;
            }
        }

        while (pointer != null && pointer.nextLinkNode != null){
            if (pointer.nextLinkNode.isExist(pointer.getData())){
                linkList.removeNode(pointer);
            }else{
                pointer = pointer.nextLinkNode;
            }
        }

        while(linkList != null){
            System.out.println(linkList.getData());
            linkList = linkList.nextLinkNode;
        }
    }
}
