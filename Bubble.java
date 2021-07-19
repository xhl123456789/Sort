package Sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {

        int[] a = {5,1,9,2,5,0};
       Sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void Sort(int[] n){
        if(n.length < 1){
            return ;
        }
        for(int i = 0; i < n.length -1; i++){
            for(int j = 0; j < n.length-1-i;j++){
                if(n[j] > n[j+1]){
                    int temp = n[j];
                    n[j] = n[j+1];
                    n[j+1] = temp;
                }
            }
        }
    }
}
