package stringMatch;

import java.util.ArrayList;
import java.util.List;


public class Exercise1 {
    public static List<Integer> searchRabinKarp(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();
        int patternHash = getHash(pattern, m);
        int textHash = getHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && text.substring(i, i + m).equals(pattern)) occurrences.add(i);
            if (i < n - m) textHash = modifyHash(text, i, i + m, textHash, m);
        }
        return occurrences;
    }

    private static int getHash(String str, int len) {
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash += str.charAt(i) * Math.pow(101, i);
        }
        return hash;
    }

    private static int modifyHash(String str, int oldIndex, int newIndex, int oldHash, int patternLen) {
        int newHash = oldHash - str.charAt(oldIndex);
        newHash /= 101;
        newHash += str.charAt(newIndex) * Math.pow(101, patternLen - 1);
        return newHash;
    }


    public static void main(String[] args) {
        String string = "000010001010001";
        String pattern = "0001";
        List<Integer> occurrences = searchRabinKarp(string, pattern);
        System.out.println("Pattern found at positions: " + occurrences);
    }
}
