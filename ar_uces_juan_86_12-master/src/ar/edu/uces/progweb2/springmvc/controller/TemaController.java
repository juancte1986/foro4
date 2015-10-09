package ar.edu.uces.progweb2.springmvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dao.GeneroDao;
import ar.edu.uces.progweb2.springmvc.dao.TemaDao;
import ar.edu.uces.progweb2.springmvc.dto.TemaDTO;
import ar.edu.uces.progweb2.springmvc.dto.TemaFormDTO;
import ar.edu.uces.progweb2.springmvc.model.Tema;
import ar.edu.uces.progweb2.springmvc.model.Usuario;
import ar.edu.uces.progweb2.springmvc.service.TemaService;
import ar.edu.uces.progweb2.springmvc.transformer.GeneroTransformer;
import ar.edu.uces.progweb2.springmvc.transformer.TemaTransformer;

@SessionAttributes({"usuarioSession"})
@Controller
public class TemaController {

	private TemaService temaService;
	
	@Autowired
	public void setTemaService(TemaService temaService) {
		this.temaService = temaService;
	}

	@RequestMapping(value = "/listarTemas", method = RequestMethod.GET)
	public String listarTemas(ModelMap model, @RequestParam("idGenero")Long idGenero){
		try{
			List<TemaDTO> temas = this.temaService.getTemasDTO(idGenero);
			model.addAttribute("temas",temas);
			model.addAttribute("idGenero", idGenero);
		} catch (BackendException e ) {
			model.addAttribute("error",true);
			model.addAttribute("messages","Error al recuperar lista de temas");
		}
		
		return "/views/tema.jsp";
	}

	@RequestMapping(value = "/nuevoTema", method = RequestMethod.POST)
	public @ResponseBody Map<String, List<Tema>> crearTema(@RequestBody TemaFormDTO temaForm, ModelMap model ){
		Usuario usuario = (Usuario) model.get("usuarioSession");
		this.temaDao.save(this.temaTransformer.transformToTema(temaForm, usuario));
		GeneroTransformer transformer2 = new GeneroTransformer();
		List<Tema> temas = this.temaDao.listarTemas(transformer2.transformToGenero(temaForm.getIdGenero()));
		HashMap<String, List<Tema>> mapa = new HashMap<String,List<Tema>>();
		mapa.put("temas", temas);
		
		return mapa;
	}
}
