package Crack.Chp8;

/**
 * Created by Tong on 2017/2/14.
 */

/*
* 实现算法: 冒泡排序
*
* 思路:
* 进行n-1次循环,每一次循环都将最大(小)的数放在数组的末(头)端。
*   一次循环的过程:
*       从第一个元素开始,一次比较相邻的两个数,如果比后面的元素大(小),则两者交换位置,不然则不交换
*
* 外层循环控制的是这一次冒出的是第i大(小的元素)
* 内层循环控制的是比较后,是否交换元素
*
* 这两层循环最坏情况下的比较次数是n-1 + n-2 + n-3 + ... +1 = O(n^2)
*
* 故冒泡排序的时间复杂度为O(n^2), 有一个tmp使用了,空间复杂度为O(1)
* */

public class BubbleSort {
    public static int a = 0;

    public static int[] increaseSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] <= array[j+1]) {
                    continue;
                } else {
                    array = exchange(array, j, j+1);
                }
            }
        }

        return array;
    }

    public static int[] decreaseSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[j] <= array[j-1]) {
                    continue;
                }else {
                    exchange(array, j, j-1);
                }
            }
        }

        return array;
    }

    public static int[] exchange(int[] array,int i, int j){
        int tmp = 0;

        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort1 = new BubbleSort();
        BubbleSort bubbleSort2 = new BubbleSort();

        System.out.println(bubbleSort1.a);
        System.out.println(bubbleSort2.a);
    }
}
