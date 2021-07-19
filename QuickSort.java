package Sort;

import java.util.Arrays;




public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,7,4,2,4,9};
        quickSort(arr,0,arr.length-1);
        //NetherLandFlag(arr,4);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 荷兰国旗问题：给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
     * 要求额外空间复杂度O(1）,时间复杂度 O(N）
     * 改进：等于的数放中间
     * 总体来说思路是这样的：把数组分为三个区域：小于，等于，大于
     * 用以指针在数组上走，并判断这个数是否大于等于num，如果是就放到相应的区域
     * 注意几个细节：
     * （1）刚开始做用了for循环，不要用for循环，做不出来
     * （2）大于的时候不要index++，因为有可能换过来还是大的那个
     */
    public static int[] NetherLandFlag(int[] arr,int num){
        if(arr.length <= 1){
            return null;
        }
        int left_s = -1;
        int right_s = arr.length;
        int index = 0;
        while(index < right_s){
            if(arr[index] < num){
                swap(arr,++left_s,index++);
            }else if(arr[index] > num){
                swap(arr,index,--right_s);
            }else{
                index++;
            }
        }
        return new int[] {left_s,right_s}; //返回的是等于区域的边界范围有时候可能会用到
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr,int L,int R){
        if(L >= R){
            return;
        }
        int mid =  arr[R-1];
        int left = L-1; //左边从-1开始
        int right = R-1; //因为拿的最后一个数做的中间一个数，所以不包含，最后换一下它1
        int index = L;
        while(index < right){
            if(arr[index] < mid){
                swap(arr,++left,index++);
            }else if(arr[index] > mid){
                swap(arr,index,--right);
            }else{
                index++;
            }
        }
        swap(arr,R-1,right++);
        quickSort(arr,L,left);
        quickSort(arr,right,R);
    }
    /*
    在数组的最左边和左右边都有·一个指针，把两个指针往中间移动，
    如果比中间的那个值大就放到右边，比中间值小就放到右边
    * */
    public static void BadQuickSort(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int L  = left;
        int R = right;
        int t = 0;
        int mid = (L + R)/2;
        while(L < R){
            while(arr[L] < arr[mid]){
                L++;
            }
            while(arr[R]>arr[mid]){
                R--;
            }
            //两边的值都比中间的小和大
            if(L >= R){
                break;
            }
            //交换
            if(L < R){
                t = arr[L];
                arr[L] = arr[R];
                arr[R] = t;
            }
            if(arr[L] == arr[mid]){
                L++;
            }
            if(arr[R] == arr[mid]){
                R--;
            }
        }
        if(L == R){
            R--;
            L++;
        }
        //向左递归
        if(left < R){
            BadQuickSort(arr,left,R);
        }
        //向右递归
        if(right > L){
            BadQuickSort(arr,L,right);
        }
    }


}
