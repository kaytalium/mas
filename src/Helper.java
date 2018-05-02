import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

	public Helper() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getCurrentDate(String format) {
		Date now = new Date();
		if(format == null || format.equals("")) {
			format = "dd-M-yyyy";
		}
		SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
		
		return dateFormatter.format(now).toString();
	}

}
