package ar.edu.uces.progweb2.springmvc.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatFechaHelper {
	
	 private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	 
	 public String formatearFecha(Date date){
		 return DATE_FORMAT.format(date);
	 }
}
