package DataStructure_Algorithms.LeetCode;

import java.util.*;

public class EveryElementApearTwice_FindMissing {
    public static void main(String[] args) {
        EveryElementApearTwice_FindMissing s = new EveryElementApearTwice_FindMissing();
        int arr[] = {4,1,2,1,2};
        System.out.println(s.singleNumber(arr));
        System.out.println(s.SingleNr(arr));
        System.out.println(s.usingStack(arr));
    }

    public int singleNumber(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (!list.contains(i)) {
                list.add(i);
            } else {
                list.remove(new Integer(i));
            }
        }
        return list.get(0);
    }

    public int SingleNr(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int x = 0;
        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash.get(i) == +1) {
                x += i;
            }
        }
        return x;
    }

    public int usingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(arr);
        int missing = 0;
        for (int i : arr) {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            }
            else{
                stack.push(i);
            }
        }
        for (int i : stack) {
            missing += i;
            System.out.println("Missing number using stack is: " + i);
        }
        return missing;
    }
}

