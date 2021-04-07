package DataStructure_Algorithms.LeetCode;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindDisspearNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new LinkedList<>();
        Set<Integer> hs = new HashSet<>();
        for(int i: nums)
            hs.add(i);

        for(int i = 1; i<= n; i++){
            if(!hs.contains(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindDisspearNumbers t = new FindDisspearNumbers();
        int [] nums = {1,2,4,5,6,8};
        System.out.println(t.findDisappearedNumbers(nums));
    }
}
