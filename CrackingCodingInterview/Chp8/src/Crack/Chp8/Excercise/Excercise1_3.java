package Crack.Chp8.Excercise;

/**
 * Created by Tong on 2017/2/10.
 */

/*
* 实现算法:
* 确定一个字符串a进行重新排列后能否称为字符串b?
*
* 思路:
* 只有当两个字符串中的字符完全一样时才能够互相转换;
* 故只要看字符串a与字符串b的hash表是否完全一样即可
*
* 输入为字符串,暂时为英文字符加上数字与标点符号
*
* hash表定义如下:
* 1、存储数组:存储字符出现的次数,维度:95维;
* 2、对字符串中的每个字符进行hash计算, hash(key) = key - 32;
* 3、遇到一个字符则在字符所在的位置加一;
* 4、最后比较两个hashTable就可知是否能够相互转换
* */

public class Excercise1_3 {
    private HashTable hashTable;

    public Excercise1_3(){
        hashTable = new HashTable();
    }

    public class HashTable{
        private int[] table;

        public HashTable(){
            table = new int[95];
        }

        public int hashCode(char c){
            int acsiiCode = (int) c;

            int hashCode = acsiiCode - 32;
            return hashCode;
        }

        public void put(char c){
            int index = hashCode(c);

            table[index] += 1;
        }

        public int[] getTable(){
            return table;
        }

        public void putAll(String str){
//            if (str == null || str.length() <= 0){
//                System.out.println();
//                return;
//            }
            char[] charArray = str.toCharArray();

            for (char c : charArray){
                put(c);
            }
        }

        public boolean equals(HashTable ht) {
            if (this.getTable().length != ht.getTable().length){
                return false;
            }

            for (int i = 0; i<ht.getTable().length; i++){
                if (this.getTable()[i] != ht.getTable()[i]){
                    return false;
                }else{
                    continue;
                }
            }

            return true;
        }
    }

    public static void main(String[] args){
        Excercise1_3 ex1 = new Excercise1_3();
        Excercise1_3 ex2 = new Excercise1_3();

        String str1 = "abcd";
        String str2 = "adbc";
        String str3 = "ddsw";
        String str4 = "ddsw";

        ex1.hashTable.putAll(str1);
        ex2.hashTable.putAll(str3);

        boolean result = ex1.hashTable.equals(ex2.hashTable);

        System.out.println(result);
    }
}
