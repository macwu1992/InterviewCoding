package Crack.Chp8.Excercise;

/**
 * Created by Tong on 2017/2/10.
 */
/*
* 实现算法:
* 将一个字符串进行反转后输出
*
* 思路:
* 输入为字符串,这里默认为英文字符
* 找到字符串的中间位置,以中间位置为轴,对字符串进行头尾交换
* */

public class Excercise1_2 {
    public String reverse(String str){
        char[] charArray = str.toCharArray();

        int n = charArray.length-1;
        int mid = n/2;

        char tmp;

        for (int i=0;i<=mid;i++){
            tmp = charArray[i];
            charArray[i] = charArray[n-i];
            charArray[n-i] = tmp;
        }

        return (new String(charArray));
    }

    public static void main(String[] args){
        String s = "WuTong";
        Excercise1_2 excercise1_2 = new Excercise1_2();
        String s1 = excercise1_2.reverse(s);
        System.out.println(s1);
    }
}
