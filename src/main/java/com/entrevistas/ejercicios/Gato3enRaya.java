package com.entrevistas.ejercicios;

/*
 * Crea una función que analice una matriz 3x3 compuesta por "X" y "O"
 * y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
 *   O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta.
 * Se podría representar con un vacío "", por ejemplo.
 */

public class Gato3enRaya {
    public static final String X = "X";
    public static final String O = "O";
    public static final String EMPTY = "";


    public static void main(String[] args) {

        String[][] board = {
                {"X","X","X"},
                {"O","O",""},
                {"","",""}
        };

        String[][] board2 = {
                {"X","O","X"},
                {"O","O","O"},
                {"X","X",""}
        };

        String[][] board3 = {
                {"X","O","X"},
                {"O","X","O"},
                {"O","X","O"}
        };

        System.out.println("El juego lo gana: " + juagaGato(board3));

    }

    private static String juagaGato(String[][] board) {

        if (!isValidoBoard(board) ) {
            return "Board no valido - nulo";
        }

        int cuentaX = 0;
        int cuentaO = 0;

        // cuenta X y O
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (X.equals(board[i][j]) ) cuentaX++;
                else if (O.equals(board[i][j]) ) cuentaO++;
            }
        }

        // validar el orden de los turnos
        if ( (cuentaO > cuentaX) || (cuentaX - cuentaO > 1) )
            return "Orden de turnos no coinciden - Nulo";

        //ver quien gana el juego
        boolean ganaX = quienGana(board, X);
        boolean ganaO = quienGana(board, O);

        // no pueden ganar ambos
        if (ganaX && ganaO)
            return "no pueden ganar ambos - Nulo";

        //validando quien gana con su cuenta
        if (ganaX && (cuentaX == cuentaO))
            return "No puede ganar X y tener numero de intentos igual a O - Nulo";

        if (ganaO && (cuentaX > cuentaO))
            return "No puede ganar O y tenmer numero de intentos menor que X - Nulo";

        if (ganaX)
            return "Gano X";

        if (ganaO)
            return "Gano O";

        return "Empate";


    }

    private static boolean isValidoBoard(String[][] board) {

        if (board == null || board.length != 3)
            return false;

        for(int i = 0; i < 3; i++){
            if (board[i] == null || board[i].length != 3)
                return false;

            for(int j = 0; j < 3; j++){
                String valor = board[i][j];

                if (valor == null)
                    return false;

                if ( !valor.equals(X) && !valor.equals(O) && !valor.equals(EMPTY) )
                    return false;
            }
        }
        return true;
    }

    private static boolean quienGana(String[][] board, String jugador) {
        // checar filas y columnas
        for(int i = 0; i < 3; i++){
            if (jugador.equals(board[i][0]) && jugador.equals(board[i][1]) && jugador.equals(board[i][2]) )
                return true;
            if (jugador.equals(board[0][i]) && jugador.equals(board[1][i]) && jugador.equals(board[2][i]) )
                return true;
        }

        // checar diagonal
        if (jugador.equals(board[0][0]) && jugador.equals(board[1][1]) && jugador.equals(board[2][2]) )
            return true;
        if (jugador.equals(board[0][2]) && jugador.equals(board[1][1]) && jugador.equals(board[2][0]) )
            return true;

        return false;

    }
}
