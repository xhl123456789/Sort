package Sort;

import java.util.Arrays;

public class MergSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * 分为分治和合并两个步骤
    * 分：
    * 采用递归的方式来进行分的
    * 将数据分为两个一组，两个一组的，然后进行一次一次的合并，都是采用递归的方式来搞的
    * 合并1:比较左右两边，小的就放到临时数组中，相应的变量加一
    * 2：将剩余的全部放到temp数组中
    * 3：将temp的数据依次放入到原数组中*/
    //分
    public static void mergSort(int[] arr,int left, int right,int[]temp){
        if(left < right){
            int mid = (left+right)/2;
            //左递归
            mergSort(arr,left,mid,temp);
            //右递归
            mergSort(arr,mid+1,right,temp);
            merg(arr,left,mid,right,temp);
        }


    }
    //合并
    public static void merg(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j= mid+1;
        int t = 0;//临时变量，用来记录临时数组的
        //比较两边的数据的大小，小的就放入临时数组
        while(i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
            //将剩下的全部放入临时数组中
            while (i <= mid) {
                temp[t] = arr[i];
                t++;
                i++;
            }
            while (j <= right) {
                temp[t] = arr[j];
                t++;
                j++;
            }
            //完成后，将临时数组中的所有值考回原来的数组
            // System.out.println(Arrays.toString(temp));
            t = 0;
            int templeft = left;
            System.out.println("zzz" + left + "zzz" + right);
            while (templeft <= right) {
                arr[templeft] = temp[t];
                t++;
                templeft++;
            }

    }
}
