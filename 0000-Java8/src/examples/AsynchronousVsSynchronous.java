package examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author eearroyo
 *
 */

public class AsynchronousVsSynchronous {
    public static void main(final String[] args) {
        stopwatch(() -> {
            // Synchronous:
            int x1 = compute(2);
            int x2 = add(x1, 2);
            int y = compute(4);
            int r = add(x2, y);
            println("Result: " + r);
        });

        stopwatch(() -> {
            // Asynchronous:
            CompletableFuture<Integer> x1 = CompletableFuture.supplyAsync(() -> compute(2));
            CompletableFuture<Integer> x2 = x1.thenApply(x -> add(x, 2));
            CompletableFuture<Integer> x3 = x1.thenApplyAsync(x -> add(x, 2));
            CompletableFuture<Integer> y = CompletableFuture.supplyAsync(() -> compute(4));
            CompletableFuture<Integer> r = x2.thenCombine(y, (i, j) -> add(i, j));
            // Block and wait for results (avoid this in production code!):
            try { 
            	println("Result: " + r.get()); 
//            	r.whenComplete((result, ex) -> System.out.println("[" + Thread.currentThread().getName() + "]: "+result+"\t"+ex))
//                	.exceptionally(ex -> { System.out.println("ERROR: "+ex); return 0; });
//            	r.completeExceptionally(new InterruptedException());
            	
            } catch (ExecutionException | InterruptedException e) { 
            	e.printStackTrace(); 
            }
        });
    }

    private static int compute(final int x) {
        println("Computing " + x + "...");
        sleep(x, SECONDS);
        println("Computed " + x + ".");
        return x;
    }

    private static int add(final int x, final int y) {
        println("Adding " + x + " and " + y + "...");
        sleep(2, SECONDS);
        final int r = x + y;
        println("Added " + x + " and " + y + ".");
        return r;
    }

    private static void sleep(final int duration, final TimeUnit unit) {
        try { unit.sleep(duration); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    private static void println(final String message) {
        System.out.println("[" + Thread.currentThread().getName() + "]: " + message);
    }

    private static void stopwatch(final Runnable action) {
        final long begin = System.currentTimeMillis();
        action.run();
//        System.out.println(begin);
//        System.out.println(System.currentTimeMillis());
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - begin) / 1000 + " seconds.");
        System.out.println();
    }
}