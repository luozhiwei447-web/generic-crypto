package com.ray.crypto.api;


/**
 *
 *
 * @author rayluo
 * @version 1.0
 * @date 2025/10/27
 */
public class Test {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeList = new int[m + n];
        int forI = Math.max(m, n);
        int index = 0;
        for (int i = 0; i < forI; i++) {
            if (m > i) {
                mergeList[index] = nums1[i];
                sort(index,mergeList);
                index++;
            }
            if (n > i) {
                mergeList[index] = nums2[i];
                sort(index,mergeList);
                index++;
            }
        }
    }

    public static void sort(int index,int[] mergeList){
        if (index > 0 && mergeList[index] < mergeList[index - 1]) {
            int a = mergeList[index];
            mergeList[index] = mergeList[index - 1];
            mergeList[index - 1] = a;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        merge(nums1, 1, nums2, 0);
    }
}
