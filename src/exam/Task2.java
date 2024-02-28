package exam;

public class Task2 {
    public static int minOperations(int[] array1, int[] array2) {
        int[][] dp = new int[array1.length + 1][array2.length + 1];

        for (int i = 0; i <= array1.length; i++) dp[i][0] = i;
        
        for (int j = 0; j <= array2.length; j++) dp[0][j] = j;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= array2.length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= array2.length; j++) {
                System.out.print(dp[i][j]+" ");
            } System.out.println();
        }

        return dp[array1.length][array2.length];
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Gifts Values: 30 21 15 12 4" );
        int[] array = {30, 21, 15, 12, 4};
        int [] sortedArray = {4, 12, 15, 21, 30};
        int procesessNumber = minOperations(array, sortedArray);
        System.out.println("Result:" + procesessNumber);
        System.out.println();
    }
}
