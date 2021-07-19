package Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr =  {1,6,5,3,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        Selectsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Selectsort(int[] arr){
        int min = 0;
        for(int i = 0; i<arr.length - 1;i++){
            min = arr[i];
            for(int j = i+1;j < arr.length;j++){
                if(arr[j] < min){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    min = arr[i];
                }
            }
        }
    }
}
