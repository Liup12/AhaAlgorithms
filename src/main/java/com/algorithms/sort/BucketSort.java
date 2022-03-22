package com.algorithms.sort;

/**
 * @author : xuande
 * @date : 2022-03-22 22:24
 **/
public class BucketSort {

    /**
     * 0 到 10 桶排序
     * @param args
     */
    public static void sort(int [] args){
        int [] bucket = new int[11];
        for (int i = 0; i < args.length; i++) {
            bucket[args[i]]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                System.out.println(i);
            }
        }
    }


    public static void main(String[] args) {
        int [] sortArgs = {1,4,5,3,6,10,8};
        sort(sortArgs);
    }
}
