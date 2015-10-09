package ar.edu.uces.progweb2.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.RespuestaDTO;
import ar.edu.uces.progweb2.springmvc.helper.ParseJsonHelper;
import ar.edu.uces.progweb2.springmvc.model.Usuario;
import ar.edu.uces.progweb2.springmvc.service.RespuestaService;

@SessionAttributes({"usuarioSession"})
@Controller
public class RespuestaController {

	private RespuestaService respuestaService;
	private ParseJsonHelper<RespuestaDTO> parseJsonHelper;
	 
	@Autowired
	public void setParseJsonHelper(ParseJsonHelper<RespuestaDTO> parseJsonHelper) {
		this.parseJsonHelper = parseJsonHelper;
	}

	@Autowired
	public void setRespuestaService(RespuestaService respuestaService) {
		this.respuestaService = respuestaService;
	}

	@RequestMapping(value ="/respuesta/{id}", method = RequestMethod.GET)
	public String getRespuestas(@PathVariable long id, ModelMap model){
		try {
			List<RespuestaDTO> respuestas = this.respuestaService.getRespuestasDTO(id);
			model.addAttribute("idTema", id);
			model.addAttribute("respuestas", this.parseJsonHelper.getJson(respuestas));
		} catch (BackendException e) {
			model.addAttribute("error",true);
			model.addAttribute("message","Error al obtener la lista de respuesta");
		}	
		return "/views/respuesta.jsp";
	}
	
	@RequestMapping(value = "/cargarRespuesta/{id}", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> cargarRespuesta(@PathVariable Long idTema, @RequestBody String texto, ModelMap model){
		Usuario usuario = (Usuario) model.get("usuarioSession");
		Map<String, Object> mapa= new HashMap<String, Object>();
		
		try{
			this.respuestaService.saveOrUpdate(usuario, idTema, texto);
			List<RespuestaDTO> respuestas = this.respuestaService.getRespuestasDTO(idTema);
			mapa.put("respuestas", respuestas );
			
		} catch (BackendException e) {
			mapa.put("error",true);
			mapa.put("message","Error al cargar respuesta");
		}
		return mapa;
	}
	
}
