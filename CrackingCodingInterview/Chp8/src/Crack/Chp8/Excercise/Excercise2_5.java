package Crack.Chp8.Excercise;

import Crack.Chp8.MyLinkNode;

/**
 * Created by Tong on 2017/2/10.
 */

/*
* 实现算法:
* 给定一个数,使用单链表存储,低位在表头,高位在表尾,实现两个数的加法
*
* 思路:
* 1、有3个链表,其中2个存储加数,1个存储结果;
* 2、主要实现进位的操作,从2个加数的链表的表头开始,相加,若没有进位,则将结果放入第3个链表相应位置即可,若有进位则取余,放入相应位置,并记录进位;
* 3、直到有一个表到了表尾,此时查看进位标记,若有进位,则新生成一个单节点,与余下的更长的链表进行相加,将相加结果直接链入第3个表。
* */

public class Excercise2_5 {
    public static MyLinkNode linkListAdd(MyLinkNode<Integer> addNum_1, MyLinkNode<Integer> addNum_2){
        MyLinkNode<Integer> resultList = new MyLinkNode();

        MyLinkNode<Integer> firstPointer = addNum_1;
        MyLinkNode<Integer> secondPointer = addNum_2;

        MyLinkNode<Integer> resultPointer = resultList;

        if (addNum_1 == null || addNum_2 == null || addNum_1.getData() == null || addNum_2.getData() == null){
            return null;
        }

        boolean flag = false;

        if (firstPointer.getData().intValue() < 0 || firstPointer.getData().intValue() > 9
            || secondPointer.getData().intValue() < 0 || secondPointer.getData().intValue() < 0){
            return null;
        }else{
            while(firstPointer != null && secondPointer != null){
                int firstDigit = firstPointer.getData().intValue();
                int secondDigit = secondPointer.getData().intValue();
                int resultDigit = 0;

                if (resultPointer != null && resultPointer.getData() != null){
                    resultDigit = resultPointer.getData();
                }

                resultDigit += (firstDigit + secondDigit);

                if (resultDigit > 10){
                    resultDigit = resultDigit%10;
                    flag = true;
                }

                resultPointer.setData(resultDigit);

                if (flag){
                    resultList.appendToTail(1);
                }else if (firstPointer.nextLinkNode != null || secondPointer.nextLinkNode != null){
                    resultList.appendToTail(0);

                    firstPointer = firstPointer.nextLinkNode;
                    secondPointer = secondPointer.nextLinkNode;
                    resultPointer = resultPointer.nextLinkNode;
                }
            }

            if (firstPointer == null && secondPointer != null){
                resultList.nextLinkNode = linkListAdd(resultPointer, secondPointer);
            }else if(secondPointer == null && firstPointer != null){
                resultList.nextLinkNode = linkListAdd(resultPointer, firstPointer);
            }

            resultList.removeNode(resultPointer);
        }

        return resultList;
    }

    public static void main(String[] args){
        MyLinkNode<Integer> addNum_1 = new MyLinkNode();
        MyLinkNode<Integer> addNum_2 = new MyLinkNode();
        MyLinkNode<Integer> result;

        Integer[] num_1 = {7,1,6};
        Integer[] num_2 = {5,9,2};

        addNum_1.appendAllToTail(num_1);
        addNum_2.appendAllToTail(num_2);

        result = Excercise2_5.linkListAdd(addNum_1, addNum_2);

        MyLinkNode<Integer> resultPointer = result;

        while(resultPointer != null){
            System.out.print(resultPointer.getData());
        }
    }
}
