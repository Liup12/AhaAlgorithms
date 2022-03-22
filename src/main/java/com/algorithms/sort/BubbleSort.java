package com.algorithms.sort;

/**
 * @author : xuande
 * @date : 2022-03-22 22:32
 **/
public class BubbleSort {

    public static void sort(int [] sortArr){
        for (int i = 1; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - 1; j++) {
                if (sortArr[j] > sortArr[j+1]){
                    int temp = sortArr[j+1];
                    sortArr[j+1] = sortArr[j];
                    sortArr[j] = temp;
                }
            }
        }
        printArr(sortArr);
    }


    /**
     * 使用break标识提前退出有序数组循环
     * @param sortArr
     */
    public static void sort2(int [] sortArr){
        for (int i = 1; i < sortArr.length - 1; i++) {
            boolean breakFlag = true;
            for (int j = 0; j < sortArr.length - 1; j++) {
                if (sortArr[j] > sortArr[j+1]){
                    int temp = sortArr[j+1];
                    sortArr[j+1] = sortArr[j];
                    sortArr[j] = temp;
                    breakFlag = false;
                }
            }

            if (breakFlag){
                break;
            }
        }
        printArr(sortArr);
    }

    private static void printArr(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] sortArgs = {7,4,5,3,6,10,8};
        sort2(sortArgs);
    }


}
