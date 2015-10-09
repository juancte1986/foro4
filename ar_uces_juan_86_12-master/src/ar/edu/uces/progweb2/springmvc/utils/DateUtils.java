package ar.edu.uces.progweb2.springmvc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	 private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	 
	 public static String formatearFecha(Date date){
		 return DATE_FORMAT.format(date);
	 }
}
