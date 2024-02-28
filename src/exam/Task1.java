package exam;

public class Task1 {
    public int function(int n, int [] dp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        
        dp[n] = function(n - 1, dp) + function(n - 2, dp) + function(n - 3, dp);
        
        return dp[n];
        
    }

    int topDown(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (memo[n] == 0) {
            memo[n] = topDown(n-1, memo) + topDown(n-2, memo) + topDown(n-3, memo);
        }
        return memo[n];
    }

    int bottomUp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
            Task1 evaluation = new Task1();
            int[] array = new int[11];
            int resultTopDown = evaluation.topDown(10, array);
            int resultBottomUp = evaluation.topDown(10, array);

            System.out.println("Result using Top-Down: \n"+resultTopDown);
            System.out.println();
            System.out.println("Result using Bottom-Up: \n"+resultBottomUp);
        }
}
