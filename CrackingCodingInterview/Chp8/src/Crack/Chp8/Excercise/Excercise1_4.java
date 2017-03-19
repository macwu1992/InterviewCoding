package Crack.Chp8.Excercise;

/**
 * Created by Tong on 2017/2/10.
 */

/*
* 实现算法:
* 将字符串中的所有空格替换为'%20'
*
* 思路:
* 由于一个空格占1位,'%20'占3位,故新字符串应该为原字符串的长度加上空格数＊2
* newCharArray.length = charArray.length+space*2
*
* 如果是从头到尾进行替换,则每次插入'%','2','0'都会移动后面的字符。复杂度比较高,为O(space*2*n)
*
* 但如果从尾向头进行移动,只需要将所有的字符移动一次就好。
*
* 使用两个指针,p1指向newCharArray中从尾向头的第一个非空字符,p2指向newCharArray中的最后一位
* 如果p1指向的字符为空格,那么p2所指的地方就开始赋为'0' '2' '%';
* 如果p1指向的字符不是空格,那么就将p1所指的字符赋给p2所指的位置。
* */

public class Excercise1_4 {
    public String replaceSpace(String str){
        if(str == null || str.length() == 0){
            return null;
        }

        char[] charArray = str.toCharArray();

        int spaceCount = 0;


        for (int i=0;i<charArray.length;i++){
//            newCharArray[i] = charArray[i];
            if (charArray[i] == ' ') {
                spaceCount++;
            }
        }

        char[] newCharArray = new char[charArray.length+spaceCount*2];

        for (int i=0;i<charArray.length;i++){
            newCharArray[i] = charArray[i];
        }

        int i = newCharArray.length-1;
        while(newCharArray[i] == 0 && i>=0){
            i--;
        }

        int j = newCharArray.length-1;

        while (i>=0 && j>=0){
            if(newCharArray[i] != ' '){
                newCharArray[j] = newCharArray[i];
                i--;
                j--;
            }else{
                newCharArray[j--] = '0';
                newCharArray[j--] = '2';
                newCharArray[j--] = '%';
                i--;
            }
        }

        return (new String(newCharArray));
    }

    public static void main(String[] args){
        Excercise1_4 excercise1_4 = new Excercise1_4();
        String s = "asd asdasd";
        System.out.print(excercise1_4.replaceSpace(s));
    }
}
