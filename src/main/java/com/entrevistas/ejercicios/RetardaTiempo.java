package com.entrevistas.ejercicios;

import java.util.concurrent.*;

public class RetardaTiempo {

    public static final ScheduledExecutorService SCHEDULER = Executors.newScheduledThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public static void main(String[] args) {

        System.out.println("Inicio del prgrama....");

        CompletableFuture<Integer> result1 = addAsync(5, 3, 3);
        CompletableFuture<Integer> result2 = addAsync(10, 20, 2);

        result1.thenAccept(r ->
                System.out.println("Resulado 1 : " + r)
        );

        result2.thenAccept(r ->
                System.out.println("Resulado 1 : " + r)
        );

        System.out.println("El programa sigue ejecutandose ....");

        SCHEDULER.shutdown();
    }

    public static CompletableFuture<Integer> addAsync(int a, int b, int delaySecods){

        CompletableFuture<Integer> future = new CompletableFuture<>();

        SCHEDULER.schedule(() -> {
            try{
                int result = Math.absExact(a +b);
                future.complete(result);
            } catch(Exception e) {
                        future.completeExceptionally(e);
                    }

                }, delaySecods, TimeUnit.SECONDS
                );
        return future;
    }
}
