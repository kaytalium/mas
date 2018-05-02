import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateConverter {

	
	public static Long getAge(Date date) {
		LocalDateTime now = LocalDateTime.now(); 
		
		String[] params = dateFormatter(null,date).split(":");
		LocalDate start = LocalDate.of(Integer.parseInt(params[0]),Integer.parseInt(params[1]),Integer.parseInt(params[2]));
		Long years = ChronoUnit.YEARS.between(start, now);
		return years;
	}
	
	public static String dateFormatter(String format, Date date) {
		if(format == null) {
			//"HH:mm:ss:ss"
			format = "YYYY:MM:dd";
		}
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);		
	}

	
	
	
	
}
