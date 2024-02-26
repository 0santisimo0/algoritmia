package lcsPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LcsExercise { 

    public static int getLcs(String string1, String string2) {
        if (string1 == null || string2 == null || string1.isEmpty() || string2.isEmpty()) return 0;

        int sizeA = string1.length(), sizeB = string2.length();

        int[][] dp = new int[sizeA + 1][sizeB + 1];

        for (int i = 1; i <= sizeA; ++i)
        {
            for (int j = 1; j <= sizeB; ++j)
            {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[sizeA][sizeB];
    }

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("text 1:");
        String string1 = br.readLine();

        System.out.println("text 2:");
        String string2 = br.readLine();

        int result = getLcs(string1, string2);
        System.out.println("Result: "+result);
    }
    
}
