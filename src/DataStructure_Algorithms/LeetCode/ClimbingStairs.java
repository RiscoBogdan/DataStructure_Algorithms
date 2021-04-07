package DataStructure_Algorithms.LeetCode;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        ClimbingStairs cl = new ClimbingStairs();
        System.out.println(cl.solution(n));
    }

    public int solution(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int result = dp[i-2] + dp[i-1];
            dp[i] = result;
        }
        return dp[n];
    }
}
