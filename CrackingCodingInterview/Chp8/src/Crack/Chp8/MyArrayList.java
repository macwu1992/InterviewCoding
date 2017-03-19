package Crack.Chp8;
/**
 * Created by Tong on 2017/2/9.
 */
import java.util.ArrayList;
import java.util.Arrays;
import Crack.Chp8.MyHashTable;

public class MyArrayList extends MyHashTable {
    public static void main(String[] args){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        myArray.add(100);
        myArray.add(10);

        int[] a = {1,2,3,4,4};

        Arrays.sort(a);

        System.out.println(myArray.get(1));
    }
}
