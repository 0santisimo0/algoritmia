package stringMatch;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

    public static List<Integer> searchRabinKarp(char[] txt, char[] pat) {
        List<Integer> occurrences = new ArrayList<>();
        int n = txt.length, m = pat.length;
        int pattern = getHash(pat, m);
        int hash = getHash(txt, m);

        for (int i = 0; i <= n - m; i++) {
            if (pattern == hash && checkEqual(txt, i, pat)) occurrences.add(i);
            if (i < n - m) hash = modifyHash(txt, i, i + m, hash, m);
        }
        return occurrences;
    }

    private static int getHash(char[] arr, int len) {
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash += arr[i] * Math.pow(101, i);
        }
        return hash;
    }

    private static int modifyHash(char[] arr, int oldIndex, int newIndex, int oldHash, int patternLen) {
        int newHash = oldHash - arr[oldIndex];
        newHash /= 101;
        newHash += arr[newIndex] * Math.pow(101, patternLen - 1);
        return newHash;
    }

    private static boolean checkEqual(char[] arr, int start, char[] pat) {
        for (int i = 0; i < pat.length; i++) {
            if (arr[start + i] != pat[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] text = "AABAACAADAABAABA".toCharArray();
        char[] pattern = "AABA".toCharArray();
        List<Integer> occurrences = searchRabinKarp(text, pattern);
        System.out.println("Pattern found at positions: " + occurrences);

        char[] text1 = "THIS IS A TEST TEXT".toCharArray();
        char[] pattern1 = "TEST".toCharArray();
        List<Integer> occurrences1 = searchRabinKarp(text1, pattern1);
        System.out.println("Pattern found at positions: " + occurrences1);
    }
}
