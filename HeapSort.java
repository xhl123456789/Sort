package Sort;


//堆排序必须是针对完全二叉树
//堆：所有父节点的值大于子结点的值(针对完全二叉树)

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,10,3,5,1,2};
        heap_sort(arr,arr.length);
        for(int n: arr){
            System.out.println(n);
        }
    }
    public static void swap(int[] tree, int max, int i){
        int temp = tree[max];
        tree[max] =tree[i];
        tree[i] = temp;
    }
    //i:对哪一个结点进行heapify
    //n:数组的长度
    //这是针对数不是那么乱，直接一次heapify就可以得到堆
    public static  void heapify(int[] tree, int n, int i){
        if(i >= n){
            return ;
        }
        int c1 = 2*i+1; //左
        int c2 = 2*i+2;  //右
        int max = i;  //记录三个数中最大值的下标
        if(c1<n && tree[c1] > tree[max]){  //检测c1是否越界 判断左子结点是否大于父子结点
            max = c1;
        }
        if(c2<n && tree[c2] > tree[max]){  //检测c2是否越界 判断右子结点是否大于父子结点
            max = c2;
        }
        //此时就得到了max，三个数中的最大数的下标
        if(max != i){   //如果父节点不是最大值，此时max已经指向子节点
            swap(tree,max,i);  //把最大值放到父节点
            heapify(tree,n,max);  //想象这么一个问题，3 5 4 第一次肯定时4和三进行交换，但是其实5才是最大数
                                    //所以要进行两次  此时的max是指向子节点的，此时在对它的子节点进行heapify
        }

    }
    /**从下往上heapify*/
    public static void build_heap(int[] tree, int n){
        int last_node = n-1;   //指向最后一个结点
        int parent = (last_node-1)/2;  //最后一个结点的父节点
        int i;
        for(i = parent; i>=0;i--){
            heapify(tree,n,i);  //第一个参数数组，第二个参数 数组的长度，第三格参数 最后一个数的parent
        }
    }
    //大根堆构建完毕之后
    //取出堆顶那个数，和最后一个数进行交换，重新heapify
    //从后往前数逐渐减小
    public static void heap_sort(int[] tree,int n){
        build_heap(tree,n);
        for(int i = n-1;i>=0;i--){
            swap(tree,i,0);
            heapify(tree,i,0);
        }

    }
}
