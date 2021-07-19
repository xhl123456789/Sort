package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,3,28,6,4};
        Insertsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 首先来到下标为一的这个数(not zero)，这是认为它前面是有序表了
     * 然后那这个数和前面的数进行比较，比他小就往前移，比他大就不动
     * 找到合适的位置就插入进去，这就是插入排序
     * 它的时间复杂度为O（n^2） 稳定的
     * @param arr
     */
    public static void Insertsort(int arr[]){
        //有序表
        //int i = 0;
        for(int j = 1; j<arr.length;j++){  //无序表
            if(arr[j] < arr[j-1]){
                int temp = arr[j];  //记录要插入的这个数
                for(int i = j;i>=0;i--){  //拿这个数去有序表里面看合适的位置
                    if(arr[i-1]>temp) //把比这个数大的往后放
                        arr[i] = arr[i-1];
                    else{           //找到合适位置 放进去
                        arr[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    public static void InsertSort2(int[] arr){
        for(int i = 1; i < arr.length;i++){
            int temp = arr[i];
            for(int j = i; j>=0;j--){
                if(arr[j-1] > temp){
                    arr[j] = arr[j - 1];
                }else{
                    arr[j] = temp;
                    break;
                }
            }
        }
    }
}
