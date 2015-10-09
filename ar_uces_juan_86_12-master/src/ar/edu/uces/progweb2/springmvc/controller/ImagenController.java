package ar.edu.uces.progweb2.springmvc.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.helper.ImagenHelper;

@Controller
public class ImagenController {
	
	private ImagenHelper imagenHelper;
	
	@Autowired
	public void setImagenHelper(ImagenHelper imagenHelper) {
		this.imagenHelper = imagenHelper;
	}

	
	@RequestMapping(value = "/guardarImagen", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> guardarImagen (@RequestParam("file") CommonsMultipartFile file){
		Map<String, Object> out = new HashMap<String, Object>();
		if (!file.isEmpty()) {
            try {
				out.put("path",this.imagenHelper.cargarImagenes(file));
			} catch(BackendException e){
				out.put("error", true);
				out.put("message", "error al guardar la imagen");
			}
			
        }
		return 	out;
	}
}
