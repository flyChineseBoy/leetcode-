package sort;

import java.util.Arrays;

/**
 *  堆排序（大顶堆）：一个数组保存基本数据结构。
 *      我们知道在数组中，任何一个非叶子结点，假设自身的下表为i，那么它的左右孩子下标分别为2i+1,2i+2.
 *      同样，对于任何一个下标为 j 的结点，它的父结点为 j/2-1.
 *  堆排序步骤：
 *      1、初始化堆过程：（O（n））
 *          从最后一个非叶子结点开始调整，若左右孩子有人比自己大，那么将自己和大的孩子互换位置。
 *      2、沉淀堆顶（循环n次）： （ O(n*logn) ）
 *          将堆顶和最后一个叶子结点交换，然后从上至下、从左至右调整堆的顺序。
 */

public class HeapSort {


    public static void sort( int[] arr){
        // 1.初始化堆，从右到左、从小到上处理非叶子结点。
        for( int i = arr.length/2-1; i >= 0; i-- ){
            adjustHead( arr, i, arr.length );
        }
        //调整堆，每一次都将最大的元素排在最后。
        for( int j = arr.length-1; j > 0; j-- ){
            swap( arr, 0, j );
            adjustHead( arr, 0, j );
        }
    }
    public  static void swap( int[] arr, int i, int j ){
        if( i > arr.length-1 || j > arr.length-1 ){
            throw new RuntimeException("要交换的下表超出该数组长度");
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void adjustHead( int[] arr, int i, int length ){
        // 1.判断左右孩子是否大于当前结点。
        // 2.大于当前结点，则交换，否则跳过
        int left = 2*i+1;
        while( left < length ){
            if( left + 1 < length && arr[left] < arr[left+1] ){ // 如果右节点比左节点大，那么用右节点作为与父节点比较的结点。
                left++;
            }
            if( arr[i] < arr[left] ){ // 如果当前子节点更大，那么交换节点。并且处理交换后的子树部分。
                swap(arr,i,left);
                adjustHead( arr, left, length );
            }else{
                break;
            }
        }
    }
    public static void main(String[] args) {
        int []arr = {7,8,12,110,0,-1,7,6,7,11,5,12,3,0,1};
        System.out.println("排序前："+Arrays.toString(arr));
        sort(arr);
        System.out.println("排序前："+ Arrays.toString(arr));
    }
}
