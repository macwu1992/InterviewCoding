package Crack.Chp8;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Tong on 2017/2/9.
 */

/*散列表的实现:
* 1、初始化: 底层存放数据的数组
* 2、实现hash函数
* */

public class MyHashTable {
    private static final int INITIALTABLELENGTH = 11;
    private String[] table;

    public MyHashTable(){
//        this.table = new String[INITIALTABLELENGTH];
    }

    public int myHashCode(Integer key){
        int index = key.intValue()%table.length;
        return index;
    }

    public void put(Integer key, String value){
        int index = myHashCode(key);

        if (table[index] != null){
            index = myHashCode(index + (int)(Math.random() * table.length/2));
        }

        table[index] = value;
    }

//    public void putAll(){}

    public String get(int key){
        int index = myHashCode(key);

        return table[index];
    }

//    public static void main(String[] args){
//        Crack.Chp8.MyHashTable hashTable = new Crack.Chp8.MyHashTable();
//
//        hashTable.put(100, "abc");
//
//        String value = hashTable.get(100);
//
//        hashTable.put(200, "ab");
//
//        System.out.println(hashTable.get(100));
//        System.out.println(hashTable.get(200));
//    }
}
