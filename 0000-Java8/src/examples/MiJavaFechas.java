package examples;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
//import java.sql.Date;

/**
 * 
 */

/**
 * @author eearroyo
 *
 */
public class MiJavaFechas {

	static final LocalDate START_DATE = LocalDate.of(2018, Month.JANUARY, 1);
	/**
	 * 
	 */
	public MiJavaFechas() {
		// TODO Auto-generated constructor stub
		this.ejemplo();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiJavaFechas();
	}

	public void ejemplo() {
		Date fecha = new Date();
		System.out.println("Date:     "+fecha);
		System.out.println("Calendar: "+Calendar.getInstance().getTime());
		System.out.println("Java.Time:        "+LocalDateTime.now());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    System.out.println(sdf.format(fecha));
	    System.out.println();
		System.out.println(LocalDateTime.now().toLocalDate());
		System.out.println(LocalDateTime.now().toLocalTime());
		System.out.println();
		LocalDateTime vacaciones = LocalDateTime.now()
			    .plusHours(24)
			    .plusMinutes(30);
		System.out.println(vacaciones.toLocalDate());
		System.out.println(vacaciones.toLocalTime());
		System.out.println(vacaciones);
		System.out.println(START_DATE);
	}
}
