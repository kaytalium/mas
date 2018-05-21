package cw.heslop.mas;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cw.heslop.mas.objects.TimeOfDay;

public class Helper {

	private static final Helper helper = null;
	private static String startDate = "2018-05-17T00:00:00";
	private static String endDate = "2018-05-17T23:59:59";
	
	public static String getCurrentDate(String format) {
		Date now = new Date();
		if(format == null || format.equals("")) {
			format = "dd-M-yyyy";
		}
		SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
		
		return dateFormatter.format(now).toString();
	}
	
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

	public static LocalDateTime getTodayDateTimeStamp(int timeOfDay) {
		LocalDate today = LocalDate.now(ZoneId.of("Jamaica"));
		LocalDateTime todayMidnight = LocalDateTime.of(today, LocalTime.MIDNIGHT);
		LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
	
		if(timeOfDay==TimeOfDay.start) {
			return todayMidnight;
		}else {
			return tomorrowMidnight;
		}
	}
	
	public static boolean isEmail(String obj) {
		String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher((CharSequence) obj);
				
		if(matcher.find()) 
			return true;
		else
			return false;
	}

	public static String dateFormatter(String format, String date) {
		// TODO Auto-generated method stub
		if(format == null) {
			//"HH:mm:ss:ss"
			format = "YYYY:MM:dd";
		}
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);		
		
	}
	
	public static int dbrowCount(ResultSet rs) {
		int size = 0;
		try {
		    rs.last();
		    size = rs.getRow();
		    rs.beforeFirst();
		}
		catch(Exception ex) {
		    return 0;
		}
		return size;
	}
	
	public static Date createDateTime(Date date, String time) {
		
	
		//2018-05-18 06:30:00
		//yyyy-MM-dd hh:mm:ss
		
		String[] tarray = time.split(":");
		String[] darray = dateFormatter(null,date).split(":");
		
		
		 LocalDate d = LocalDate.of(Integer.parseInt(darray[0]), Integer.parseInt(darray[1]), Integer.parseInt(darray[2]));
	        LocalTime t = LocalTime.of(Integer.parseInt(tarray[0]), Integer.parseInt(tarray[1]), Integer.parseInt(tarray[2]));
	        LocalDateTime localDateTime = LocalDateTime.of(d, t);
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
	        
	        String combineDate = localDateTime.format(format);
	        
	        try {
				return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(combineDate);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	       
		
	
		 
		
		return null;
	}
	
	public static Date convertStringToDate(String date1) {
		 try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 return null;
	}
	
	public static String convertToJavaDateFormat(String d) {
		//return dd//MM/yyyy
		String[] s= d.split("-");
		return s[2]+"/"+s[1]+"/"+s[0];
		
		
		
	}

}
