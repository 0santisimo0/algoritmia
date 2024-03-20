package ininiteAut;

public class AutomataTask {
    static int getNextState(String pattern, int state, int n) {
        if (state < pattern.length() && n == pattern.charAt(state)) return state + 1;

        int nextState, i;
        for (nextState = state; nextState > 0; nextState--) {
            if (pattern.charAt(nextState - 1) == n) {
                for (i = 0; i < nextState - 1; i++) {
                    if (pattern.charAt(i) != pattern.charAt(state - nextState + 1 + i)) break;
                }
                if (i == nextState - 1) return nextState;
            }
        }

        return 0;
    }

    static void getTF(String pattern, int[][] TF) {
        int state, x;
        for (state = 0; state <= pattern.length(); ++state)
            for (x = 0; x < 256; ++x)
                TF[state][x] = getNextState(pattern, state, x);
    }

    static void search(String pattern, String text) {
        int[][] TF = new int[pattern.length() + 1][256];
        getTF(pattern, TF);

        int state = 0;
        for (int i = 0; i < text.length(); i++) {
            state = TF[state][text.charAt(i)];
            if (state == pattern.length()) {
                System.out.println("Patrón encontrado en el índice " + (i - pattern.length() + 1));
            }
        }
    }


    public static void main(String[] args) {
        String txt = "THIS IS A TEST TEXT";
        String pattern = "TEST";
        search(pattern, txt);
    }
}