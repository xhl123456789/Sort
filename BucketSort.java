package Sort;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {1,3,28,6,4};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //桶排序是典型的空间换时间的一种算法
    //首选创建一个二维数组当桶用
    //然后创建一个一维数组，记录个数,
    //首先按照各位的大小存入桶中，然后根据大小取出来，然后是十位然后是千位
    public static void bucketSort(int[] arr) {
        //创建二位数组，当桶用
        int[][] bucket = new int[10][arr.length];
        //创建一维数组，记录每个桶中存了几个数
        int[] remember = new int[10];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int z = 0, t = 1; z < (max + "").length(); z++, t *= 10) {
            //把个位放进桶中
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i] / t % 10;
                bucket[temp][remember[temp]] = arr[i];
                remember[temp]++;
            }
            //存完后取出来
            int index = 0;
            for (int k = 0; k < remember.length; k++) {
                if (remember[k] != 0) {
                    for (int l = 0; l < remember[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //清零
                remember[k] = 0;
            }
        }
    }
}
