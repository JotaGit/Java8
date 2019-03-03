package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.chrono.*;
import java.time.format.*;
import java.time.temporal.*;
import java.time.zone.*;

/**
 * 
 */

/**
 * @author eearroyo
 *
 */
public class MiJavaStream {

	/**
	 * 
	 */
	public MiJavaStream() {
		// TODO Auto-generated constructor stub
		this.ejemplo();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiJavaStream();
	}
	
	public void ejemplo() {
		List<Integer> listaNumeros = new ArrayList<Integer>();

		listaNumeros.add(1);
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(4);
		listaNumeros.add(4);

		Stream<Integer> st = listaNumeros.stream();
		System.out.println(st.filter(Predicate.isEqual(4)).count());
		
		long count = listaNumeros.stream()
								 .filter(Predicate.isEqual(4))
								 .count();
		System.out.println(count);
		
		
//		List<Articulo> registro = new ArrayList<>();
//		List<Integer> id_s = registro.stream()
//									.filter(inv -> inv.getTitle().contains("Medicinal"))
//									.sorted(comparingDouble(Invoice::getAmount).reversed())
//									.map(Invoice::getId)
//									.collect(Collectors.toList());
		
//		List<Transaction> listTransactions = new Arraylist<>(); 
//		for(Transaction t: transactions){  
//		if(t.getType() == Transaction.GROCERY){   
//		listTransactions.add(t);  
//		} 
//			} 
//		Collections.sort(listTransactions, new Comparator(){  
//		public int compare(Transaction t1, Transaction t2){   
//		return t2.getValue().compareTo(t1.getValue());  
//		} 
//		}); 
//		List<Integer> transactionIds = new ArrayList<>(); 
//		for(Transaction t: groceryTransactions){  
//		transactionsIds.add(t.getId()); 
//		}
//		Secuencia 1
//
//		List<Integer> transactionsIds = 
//		transactions.stream()   
//		.filter(t -> t.getType() == Transaction.GROCERY)   
//		.sorted(comparing(Transaction::getValue).reversed())   
//		.map(Transaction::getId)   
//		.collect(toList());
//		Secuencia 2
		
	}

	

}
