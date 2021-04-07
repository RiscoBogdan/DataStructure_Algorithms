package DataStructure_Algorithms.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber_InArray {
    public static void main(String[] args) {
     int [] arr = new int[]{0,1,3};
     MissingNumber_InArray miss = new MissingNumber_InArray();
        System.out.println(miss.missingNumber(arr));
        System.out.println(miss.missingNumberr(arr));
        System.out.println(miss.usingHash(arr));
    }
    public int missingNumber(int [] nums){
        int n = nums.length;
        int sumOfNUms = (n*(n+1)) / 2;
        int sumInArray = 0;
        for(int i = 0; i< nums.length; i++){
             sumInArray += nums[i];
        }
        return sumOfNUms - sumInArray;

    }
    public int missingNumberr(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        // Array was not missing any numbers
        return -1;
    }

    public int usingHash(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);
        int n = nums.length;
        int expected = n + 1;
        for(int i = 0; i<expected; i++){
            if(!numSet.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
