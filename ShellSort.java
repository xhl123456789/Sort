package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr= {1,0,73,5,56,12,3};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    * 希尔排序的第一种实现方法交换式，效率没有平移法好
    * 它的基本思想是：首先拿到一个数，然后与他一组的数据进行比较，
    * 如果小于前面的数就进行交换，每一组都要进行比较一次，有点像冒泡排序
    * */
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while(gap > 0){
            for(int i = gap; i < arr.length;i++){
              for(int j = i-gap;j>=0;j-=gap){
                  if(arr[j] > arr[j+gap]){
                      int temp = arr[j];
                      arr[j] = arr[j+gap];
                      arr[j+gap] = temp;
                  }
              }
            }
            gap /= 2;
            }
    }
    /*
    *希尔排序平移法
    * 就是用一个临时变量，保存当前值，
    * 用插入排序的思想，分有序表跟无序表
    */
    public static void shellSort2(int[] arr){
        int gap = arr.length / 2;
        while(gap > 0){
            for(int i = gap; i < arr.length;i++){
                int temp = arr[i];
                int j = i;
                if(temp < arr[j-gap]){
                    /*
                    * 这里只能把两个条件写在一起，因为我们需要知道J的位置*/
                    for(; j-gap >=0 && temp < arr[j-gap] ;j -= gap){
                            arr[j] = arr[j - gap];
                    }
                        arr[j] = temp;
                }
            }
            gap /= 2;
        }
    }
}

