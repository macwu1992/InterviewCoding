package Crack.Chp8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Tong on 2017/2/9.
 */
/*实现StringBuffer
* StringBuffer 主要用于将需要连接的String存于一个Cache中,一次性连接,减少字符串连接的时间复杂度
* 实现思路:
* 使用ArrayList动态数组,每次append()函数执行就是将String放入ArrayList
* 最后toString方法才将所有字符串连接
* */

public class MyStringBuffer {
    private ArrayList<String> strCache;
    private String finalStr;

    public MyStringBuffer(){
        this.strCache = new ArrayList<String>();
        this.finalStr = "";
    }

    public void append(String str){
        this.strCache.add(str);
    }

    @Override
    public String toString(){
        Iterator iter = strCache.listIterator();

        while(iter.hasNext()){
            finalStr = finalStr + iter.next();
        }

        return this.getFinalStr();
    }

    public String getFinalStr(){
        return finalStr;
    }

    public static void main(String[] args){
        String[] words = {"I", " ","am"," ","super","man"};

        MyStringBuffer myStringBuffer = new MyStringBuffer();

        for (String w: words){
            myStringBuffer.append(w);
        }

        System.out.println(myStringBuffer.toString());
    }
}
