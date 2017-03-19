package Crack.Chp8;

/**
 * Created by Tong on 2017/2/21.
 */

/*
* 实现算法: 最大子串
*
* 给定一个长度为n,含有正负数的序列L
* 输出和最大的子序列的和
*
* 思路,假设这个子序列为subSeq[i,j],当前最大值为max
* 看subSeq[i,j]+L[j+1]>max?
* 如果大于max 则更新max为subSeq[i,j]+L[j+1]
* 如果不大于max 再看subSeq[i,j]+L[j+1]>0?
*   如果大于0,则继续向后加。
*   如果不大于0,则将i设置为j+2,重新开始计算子串的和
* */
public class MaximunSubSequence {
    public int maxSubSeq(int[] seq){
        if(seq == null || seq.length == 0){
            return 0;
        }
        int n = seq.length;
        int start = 0;

        while(seq[start]<=0){
            start++;
        }

        int sum = seq[start];
        int max = sum;

        for (int i=start+1;i<n;i++){
            if(sum+seq[i]<0){
                i+=2;
            }else if()
        }
    }
}
