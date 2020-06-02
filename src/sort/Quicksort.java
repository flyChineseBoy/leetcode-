package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         暴力法：m*n
         先合并，再排序：使用快排。
         */
        for( int i = 0; i < n; i++ ){
            nums1[m+i] = nums2[i];
        }
        n = m+n;
        int leftIndex = 0;
        int rightIndex = n - 1;
        qucikSort(nums1,leftIndex,rightIndex);

    }

    /**
     * 坑——重复元素？
     * 1、等于基准值的数要放左边还是右边？
     * @param nums
     * @param leftIndex
     * @param rightIndex
     */
    static void qucikSort( int[] nums,int leftIndex,int rightIndex ){
        if( rightIndex <= leftIndex && leftIndex>=0 && rightIndex<nums.length){
            return;
        }
        int base = nums[leftIndex];
        int start = leftIndex;
        int end = rightIndex;
        while( leftIndex < rightIndex ){
            while( nums[rightIndex] > base && leftIndex < rightIndex ){
                rightIndex--;
            }
            while( nums[leftIndex] <= base && leftIndex < rightIndex ){
                leftIndex++;
            }
            if(leftIndex < rightIndex){
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = temp;
            }
        }
        //nums[leftIndex] = base;
        int temp = nums[start];
        nums[start] = nums[rightIndex];
        nums[rightIndex] = temp;

        qucikSort(nums,start,rightIndex - 1);
        qucikSort(nums, rightIndex + 1, end );
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,2,2,0};
        int[] nums2 = new int[]{1};
        merge(nums1,3,nums2,1);
        for (int i : nums1) {
            System.out.println(i);
        }

        for (Integer integer : getRow(3)) {
           // System.out.println(integer);
        }
    }


    public static List<Integer> getRow(int rowIndex) {
        /**
         和上一题相比，可以少用一些空间
         */
        rowIndex = rowIndex + 1;
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> row = new ArrayList<Integer>();
        for( int i = 0; i < rowIndex; i++ ){
            for( int j = 0; j <= i; j++ ){
                if( j == i || j == 0){
                    row.add( 1 );
                }else{
                    row.add( result.get(j) + result.get(j-1) );
                }
            }
            result.addAll(row);
            row.clear();
        }
        return result;
    }
}