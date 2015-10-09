package ar.edu.uces.progweb2.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.progweb2.springmvc.bo.EstadisticaBO;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.EstadisticasDTO;
import ar.edu.uces.progweb2.springmvc.service.EstadisticaService;

@Controller
public class EstadisticasController {
	
	private EstadisticaService estadisticaService;
	
	@Autowired
	public void setEstadisticaService(EstadisticaService estadisticaService) {
		this.estadisticaService = estadisticaService;
	}

	@RequestMapping(value = "/estadisticas", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> obtenerEstadisticas(){
		Map<String, Object> mapa = new HashMap<String, Object>();
		try{
			EstadisticasDTO estadisticasDTO = this.estadisticaService.getEstadisticas();
		    mapa.put("estadisticasDTO",estadisticasDTO);  
		} catch(BackendException e){
			 System.out.println(e);
			 mapa.put("error", true);
			 mapa.put("message", "Error al obtener las estadisticas");
		}
		return mapa;
	}
}
