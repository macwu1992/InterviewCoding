package Crack.Chp8.Excercise;

/**
 * Created by Tong on 2017/2/10.
 */

/*
* 实现算法:
* 对一个字符串中的重复字符进行压缩
*
* 思路:
* 使用hash表,一个n*2的数组,第一列保存字符,第二列保存字符出现数。字符最多就是32~126
* */

public class Excercise1_5 {
    int[] hashTabel = new int[95];

    public String compress(String str){
        if(str == null || str.length()<=0){
            return null;
        }

        char[] charArray = str.toCharArray();

        for(int i=0;i<charArray.length;i++){
            if (charArray[i]>0){
                hashTabel[((int)charArray[i]-32)]++;
            }
        }

        StringBuffer strBuffer = new StringBuffer();

        for(int j=0;j<95;j++){
            if(hashTabel[j]>0){
                strBuffer.append(((char)(j+32)));
                strBuffer.append(hashTabel[j]);
            }
        }

        return strBuffer.toString();
    }


    public static void main(String[] args){
        String s = "aabcccbbaaaaa";

        Excercise1_5 excercise1_5 = new Excercise1_5();

        System.out.print(excercise1_5.compress(s));
    }
}
