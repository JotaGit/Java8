package examples;

/**
 * 
 */

/**
 * @author eearroyo
 *
 */
public class CalculadoraLamda implements ICalculadoraLambda{

	/**
	 * 
	 */
	public CalculadoraLamda() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public void ejemplo() {
		/** INTERFACES default / static ****/
//		ICalculadoraLambda calc = new CalculadoraLamda();
//		System.out.println( calc.sumar(5, 5) );
//		System.out.println( ICalculadoraLambda.restar(5, 5) );
//		System.out.println( this.restar(5, 5) );
//		System.out.println( calc.operacion(5, 5) );
		
		/** LAMBDA **/
		ICalculadoraLambda iCalculadora2 = new CalculadoraLamda();
		System.out.println(iCalculadora2.operacion(4, 5));
		ICalculadoraLambda iCalculadora = (x,y) -> x + y; 
	    System.out.println(iCalculadora.operacion(4, 5));
	    iCalculadora = (x,y) -> x * y;
	    System.out.println(iCalculadora.operacion(4, 5));
	    
	    ICalculadoraLambda iMultiplicacion = (x,y) -> x * y;
	    System.out.println(iMultiplicacion.operacion(4, 5));
	    	    

	}

	@Override
	public int operacion(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	@Override
//	public int sumar(int x, int y) {
//		// TODO Auto-generated method stub
//		return -1;
//	}
	
//	@Override
	public int restar(int x, int y) {
		// TODO Auto-generated method stub
		return -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/** LAMBDA **/
		CalculadoraLamda calculadoraLamda = new CalculadoraLamda();
		calculadoraLamda.ejemplo();
		
	}
    
}
