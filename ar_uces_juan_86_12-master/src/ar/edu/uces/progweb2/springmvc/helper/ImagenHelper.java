package ar.edu.uces.progweb2.springmvc.helper;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;

@Component
public class ImagenHelper {
	
	public String cargarImagenes (CommonsMultipartFile file) throws BackendException{
		OutputStream os = null;
		long time = System.currentTimeMillis();
		String fileName = time+"-"+file.getOriginalFilename();
		String ruta="/home/jveron/Downloads/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springmvc/imagen-temporal/"+fileName;
		try{
			os = new BufferedOutputStream(new FileOutputStream(ruta));
			os.write(file.getBytes());
			os.flush();
		} catch (IOException e) {
			throw new BackendException(e);
		} finally {
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e){
					throw new BackendException(e);
				}
			}
		}
		return "/imagen-temporal/"+fileName;
	}

}
