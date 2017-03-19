package Crack.Chp8.Excercise;

/**
 * Created by Tong on 2017/2/10.
 */

/*
* 实现算法:
* 一个NxN大小的矩阵表示的图像,每个像素为4字节;
* 如何将图像旋转90度,如果不利用额外的空间该如何做?
*
* 思路:
* 4字节一个像素,即32位的整数可以代表
* 矩阵向左旋转90度,就是求矩阵的转置,再上下颠倒一次,
* 想有旋转90度就是向左旋转270度。
* */

public class Excercise1_6 {
    public int[][] matrixReverse(int[][] matrix){
        int tmp;
        int n = matrix.length;

        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i=0;i<(n/2);i++){
            for (int j=0;j<n;j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11},
                {12,13,14,15}
        };

        Excercise1_6 excercise1_6 = new Excercise1_6();
        int[][] m = excercise1_6.matrixReverse(matrix);
        for (int i=0;i<m.length;i++){
            System.out.println();
            for (int j=0;j<m.length;j++){
                System.out.print(m[i][j]);
                System.out.print(' ');
            }
        }

    }
}
