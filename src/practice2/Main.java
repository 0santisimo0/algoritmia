package practice2;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static Integer getLis(ArrayList<Integer> sequence) {

        int sequenceSize = sequence.size();
        int maxLength = 0;
        int[] lis = new int[sequenceSize];

        Arrays.fill(lis, 1);

        for (int i = 0; i < sequenceSize; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence.get(i) > sequence.get(j) && lis[i] < lis[j] + 1) lis[i] = lis[j] + 1;
            }

            if (lis[i] > maxLength) maxLength = lis[i];
        }


        return maxLength;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(1, 3, 1, 2, 3));

        Integer lis = getLis(inputList);

        System.out.println(lis);
    }
}