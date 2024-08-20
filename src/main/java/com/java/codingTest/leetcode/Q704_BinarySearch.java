package com.java.codingTest.leetcode;

public class Q704_BinarySearch {
    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target,
     * write a function to search target in nums.
     * If target exists, then return its index. Otherwise, return -1.
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) { // two pointer가 중간 어느 지점에서 만날 때
            mid = (start + end) / 2; // 가운데 인덱스 찾기
            if(nums[mid] == target) return mid;
            if (nums[mid] < target) {
                start = mid + 1; // nums[mid]보다 큰 수만 비교하도록
            } else {
                end = mid - 1; // nums[mid]보다 작은 수만 비교하도록
            }
        }

        return -1;
    }
}
