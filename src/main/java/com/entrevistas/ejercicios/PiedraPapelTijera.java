package com.entrevistas.ejercicios;

import com.entrevistas.Par;

import java.util.List;

public class PiedraPapelTijera {

    public static void main(String[] args) {
        List<Par<PiePaTi, PiePaTi>> partida1 = List.of(new Par(PiePaTi.PAPEL, PiePaTi.TIJERA));
        List<Par<PiePaTi, PiePaTi>> partida2 = List.of(new Par(PiePaTi.PIEDRA, PiePaTi.TIJERA));
        List<Par<PiePaTi, PiePaTi>> partida3 = List.of(new Par(PiePaTi.PAPEL, PiePaTi.PAPEL));
        List<Par<PiePaTi, PiePaTi>> partida4 = List.of(new Par(PiePaTi.PIEDRA, PiePaTi.TIJERA),
                new Par(PiePaTi.PIEDRA, PiePaTi.PAPEL),
                new Par(PiePaTi.TIJERA, PiePaTi.PAPEL));

        List<Par<PiePaTi, PiePaTi>> partida5 = List.of(new Par(PiePaTi.PAPEL, PiePaTi.TIJERA),
                new Par(PiePaTi.PIEDRA, PiePaTi.TIJERA),
                new Par(PiePaTi.TIJERA, PiePaTi.PIEDRA));

        System.out.println("Ganador de partida 1: " + juego(partida1) );
        System.out.println("Ganador de partida 2: " + juego(partida2) );
        System.out.println("Ganador de partida 3: " + juego(partida3) );
        System.out.println("Ganador de partida 4: " + juego(partida4) );
        System.out.println("Ganador de partida 5: " + juego(partida5) );

    }

    private static String juego(List<Par<PiePaTi, PiePaTi>> partida) {
        int jugador1 = 0;
        int jugador2 = 0;

        for(Par par : partida){
            if (par.llave() != par.valor()){
                if ( (par.llave() == PiePaTi.PIEDRA && par.valor() == PiePaTi.TIJERA ) ||
                        (par.llave() == PiePaTi.TIJERA && par.valor() == PiePaTi.PAPEL) ||
                        (par.llave() == PiePaTi.PAPEL && par.valor() == PiePaTi.PIEDRA) ) {
                    jugador1++;
                } else {
                    jugador2++;
                }
            }
        }
        if (jugador1 == jugador2){
            return "Empate";
        } else if (jugador1 > jugador2) {
            return "Jugador 1";
        } else {
            return "Jugador 2";
        }
    }


}
