package com.entrevistas.ejercicios.otros;

public class  WordSearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        //System.out.println(" =====================   existe   =======================================");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ///System.out.println("Manda llamar a DFS renglon " + r + " columna " + c);
                if (dfs(board, word, r, c, 0)) {
                   // System.out.println("_______________________________________________________________");
                    return true;
                }
            }
        }

        //System.out.println("_______________________________________________________________");
        return false;

    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        //System.out.println("indice = " + index);
        // Word fully matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or mismatch
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark as visited by modifying board (in-place)
        char temp = board[r][c];
        board[r][c] = '#'; // temporary mark

        // Explore 4 directions
        boolean found = dfs(board, word, r + 1, c, index + 1)
                || dfs(board, word, r - 1, c, index + 1)
                || dfs(board, word, r, c + 1, index + 1)
                || dfs(board, word, r, c - 1, index + 1);

        // Backtrack (restore cell)
        board[r][c] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSearch solver = new WordSearch();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(solver.exist(board, "ABCCED")); // true
        System.out.println(solver.exist(board, "SEE"));    // true
        System.out.println(solver.exist(board, "ABCB"));   // false
    }
}

