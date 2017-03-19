package Crack.Chp8.Excercise;

import java.util.Iterator;
/**
 * Created by Tong on 2017/2/10.
 */
/*
* 实现算法:
* 确定一个字符串的所有字符是否全都不同
* 假设不允许用其他的数据结构
*
* 思路:
* 输入为字符串,这里默认为英文字符
* 解本题第一个思路就是将每个字符的acsii码作为key,使用hashmap,有冲突则返回false,没有冲突则返回true;
* 不允许用其他的数据,即不允许用java自带的hashmap
*
* 自己定义一个hash函数即可,由于acsii码的所有字符一共有127个,其中0~31和127为控制字符;
* 32~126为英文大小写字符,数字字符,和标点符号
*
* 1、故定义一个95维的数组即可全部放下,定义hash函数为hash(key) = key - 32,可以方便的将key转换为数组下标;
* 2、将字符串中的所有字符放入hash表,只要发生冲突就返回false即可
* */

public class Excercise1_1 {
    private char[] strTable;

    public Excercise1_1(){
        strTable = new char[95];
    }

    public boolean putAll(String str){
        char[] charArray = str.toCharArray();

        if (str == null || str.length() <= 0){
            return false;
        }

        for (char c : charArray){
            int hashCode = myHashCode(c);

            if (strTable[hashCode] == '\u0000'){
                strTable[hashCode] = c;
            }else{
                return false;
            }
        }

        return true;
    }

    public int myHashCode(char c){
        int acsiiCode = (int) c;

        int hashCode = acsiiCode - 32;

        return hashCode;
    }

    public boolean isRedundant(String str){
        char[] strArray = str.toCharArray();

        for(int i=0;i<strArray.length;i++){
            for(int j=i+1;j<strArray.length;j++){
                if(charEquals(strArray[i], strArray[j])){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean charEquals(char ch1, char ch2){
        if (ch1 == ch2) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String str = "ooppp";

        Excercise1_1 excercise1_1 = new Excercise1_1();

        System.out.println(excercise1_1.isRedundant(str));
    }
}
