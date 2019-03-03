package examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MiJavaReferenceMethod {

	public MiJavaReferenceMethod() {
		// TODO Auto-generated constructor stub
		this.ejemplo();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiJavaReferenceMethod();
	}
	
	public void ejemplo() {
		List<String> letras = Arrays.asList("C", "a", "A", "b", "B");
		List<String> letras2 = Arrays.asList("C", "a", "A", "b", "B");

		/** Antes de Java8 **/
		Collections.sort(letras, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		for (String letra : letras) {
			System.out.print(letra);
		}
		System.out.println();
		

		System.out.println();
		/** Ahora con Java 8 **/
		Collections.sort(letras2, String::compareToIgnoreCase);
		for (String letra : letras2) {
			System.out.print(letra);
		}
	}
}
