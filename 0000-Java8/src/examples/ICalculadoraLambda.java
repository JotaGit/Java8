package examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author eearroyo
 * @param <E>
 *
 */
@FunctionalInterface
public interface ICalculadoraLambda {

		/** default */
		public default int sumar(int x,int y) {
			System.out.println("sumar() " + x +"+"+ y);
			return x + y;
		}
		
		/** static */
		public static int restar(int x,int y) {
			System.out.println("restar() " + x +"-"+ y);
			return x - y;
		}
		
		/** Solo puede existir un metodo abtracto en una @FunctionalInterface */
	    public int operacion (int x,int y);
//	    public int operacion2 (int x,int y);
	  
	    
	    
	    /** default */
//	    public default void sort(Comparator<? super E> c) {
//	        Collections.sort(this, c);
//	    }
	    /** static */
//	    public static <T> Stream<T> of(T... values) {
//	        return Arrays.stream(values);
//	    }
}
