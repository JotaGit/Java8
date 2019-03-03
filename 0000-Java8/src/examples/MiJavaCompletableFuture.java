package examples;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 */

/**
 * @author eearroyo
 *
 */
public class MiJavaCompletableFuture {

	private final ExecutorService executor = Executors.newFixedThreadPool(5);
	private final static Logger LOGGER = LoggerFactory.getLogger(MiJavaCompletableFuture.class);

	/**
	 * 
	 */
	public MiJavaCompletableFuture() {
		// TODO Auto-generated constructor stub
//		this.ejemplo();
		this.ejemplo_2();
//		executor.shutdownNow();
		System.out.println("executor.shutdownNow()");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiJavaCompletableFuture();
		System.out.println("END MAIN Thread "+ LocalDateTime.now().toLocalTime());
	
	}

	/**
	 * Ejemplo con Clase Future Java 1.5
	 * Usando Future.get() el cual es bloqueante del hilo de ejecución
	 */
	public void ejemplo() {
		try {
			System.out.println("INIT		" + LocalDateTime.now().toLocalTime());
			Future<String> future = this.processVeryLong("test");
			// TODO MORE THINGS
			System.out.println("isCancelled()" + future.isCancelled());
			System.out.println("isDone()" + future.isDone());
			
			System.out.println("Wait Future	" + LocalDateTime.now().toLocalTime());
			String result = future.get(6, TimeUnit.SECONDS);			

			 System.out.println("result: "+result);
			System.out.println("future.get()	" + LocalDateTime.now().toLocalTime());
		} catch (InterruptedException e) {
			System.out.println("InterruptedException: " + e.getCause());
			System.out.println("InterruptedException: " + e.getMessage());
		} catch (ExecutionException e) {
			System.out.println("ExecutionException: " + e.getCause());
			System.out.println("ExecutionException: " + e.getMessage());
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getCause());
			System.out.println("TimeoutException: " + e.getMessage());
			e.getStackTrace();
		}
		System.out.println("END		" + LocalDateTime.now().toLocalTime());
	}

	/**
	 * 
	 */
	public void ejemplo_2() {
		/** */
		// CompletableFuture<Void> thenAccept(Consumer<? super T> action);
		// CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action);
		// CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor
		// executor);

		/**Ejemplos de Completación del Futuro */
//		CompletableFuture<String> future = CompletableFuture.completedFuture("Prueba");
//		// ...
//		CompletableFuture<String> future2 = new CompletableFuture<>();
//		// other stuff
//		future2.complete("Completado!");
//		// ...
//		CompletableFuture<Void> futureAsync = CompletableFuture.runAsync(() -> {
//			// Some stuff...
//		});

		/** Un CompletableFuture que espera por otro CompletableFuture  "thenApplyAsync" */
		CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
			System.out.println("Comenzando supplyAsync for thenApply...");
			System.out.println("[" + Thread.currentThread().getName() + "]: ");
		    //Sleep.sleepSeconds(5);
		    try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		    System.out.println("Terminado supplyAsync for thenApply!");
		    return "Terminado";
		}, executor);		 
		CompletableFuture<String> futureApply = futureAsync.thenApplyAsync(s -> {
			System.out.println("Comenzando applyAsync...");
			System.out.println("[" + Thread.currentThread().getName() + "]: ");
		    //Sleep.sleepSeconds(5);
		    try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		    System.out.println("Terminado applyAsync!");
		    return s.toUpperCase();
		}, executor);		 
		futureApply.whenCompleteAsync((s, e) -> System.out.println("Resultado applyAsync: {"+ LocalDateTime.now().toLocalTime()+"}"+ s),
		    executor);

		// thenAccept
//		CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
//		    LOGGER.info("Comenzando supplyAsync for thenAccept...");
//		    Sleep.sleepSeconds(4);
//		    LOGGER.info("Terminado supplyAsync for thenAccept!");
//		    return "Terminado";
//		}, executor);		 
//		futureAsync.thenAcceptAsync(s -> {
//		    LOGGER.info("Comenzando thenAccept...");
//		    Sleep.sleepSeconds(4);
//		    LOGGER.info("Terminado thenAccept!");
//		    LOGGER.info("Resultado: {}", s);
//		}, executor);		 
//		// thenRun
//		CompletableFuture<Void> futureRun = CompletableFuture.runAsync(() -> {
//		    LOGGER.info("Comenzando runAsync for thenRun...");
//		    Sleep.sleepSeconds(4);
//		    LOGGER.info("Terminado runAsync for thenRun!");
//		}, executor);		 
//		futureRun.thenRunAsync(() -> {
//		    LOGGER.info("Comenzando thenRun...");
//		    Sleep.sleepSeconds(4);
//		    LOGGER.info("Terminado thenRun!");
//		}, executor);
//
//		
//		CompletableFuture<String> futureAsync_2 = CompletableFuture.supplyAsync(() -> {
//		    LOGGER.info("Comenzando supplyAsync with exception...");
//		    Sleep.sleepSeconds(2);
//		    LOGGER.info("Terminado supplyAsync with exception!");
//		    throw new RuntimeException("Error en el futuro");
//		}, executor);		 
//		CompletableFuture<String> futureEx = futureAsync_2.exceptionally(e -> {
//		    System.err.println("Resultado con excepción!! "+ e);
//		    return "StringPorDefecto";
//		});		 
//		futureEx.whenCompleteAsync((s, e) -> LOGGER.info("Resultado futureEx: {}", s),
//		        executor);

		
//		CompletableFuture<String> futureSupplyAsync = CompletableFuture.supplyAsync(() -> {
//			System.out.println("Comenzando supplyAsync...");
//			Sleep.sleepSeconds(3);
//			System.out.println("Terminado supplyAsync!");
//			return "Terminado";
//		}, executor);

		// LOGGER.info("Resultado bloqueando supplyAsync: " + futureSupplyAsync.get());
//		   futureRunAsync.whenCompleteAsync((s, e) -> LOGGER.info("Resultado runAsync: " + s), executor);
//		futureSupplyAsync.whenCompleteAsync((s, e) -> LOGGER.info("Resultado supplyAsync: " + s), executor);
		LOGGER.info("Terminado Ejemplo_2 thread "+ LocalDateTime.now().toLocalTime());

	}

	public Future<String> processVeryLong(String param1) throws InterruptedException {
		return executor.submit(() -> {
			TimeUnit.SECONDS.sleep(5);
			System.out.println("Terminando processVeryLong..." + LocalDateTime.now().toLocalTime());
			return param1.concat(" result");
		});
	}
}
