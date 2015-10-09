package ar.edu.uces.progweb2.springmvc.transformer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.uces.progweb2.springmvc.dao.RespuestaDao;
import ar.edu.uces.progweb2.springmvc.dao.TemaDao;
import ar.edu.uces.progweb2.springmvc.dto.RespuestaDTO;
import ar.edu.uces.progweb2.springmvc.model.Respuesta;
import ar.edu.uces.progweb2.springmvc.model.Usuario;
import ar.edu.uces.progweb2.springmvc.utils.DateUtils;

public class TransformerRespuesta {
	
	private TemaDao temaDao;
	private RespuestaDao respuestaDao;
	
	@Autowired
	public void setRespuestaDAO(RespuestaDao respuestaDao) {
		this.respuestaDao = respuestaDao;
	}

	@Autowired
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	public Respuesta crearRespuesta(Usuario usuario, Long idTema, String texto) {
		Respuesta respuesta = new Respuesta();
		respuesta.setDenuncia(0);
		respuesta.setFecha(new Date());
		respuesta.setMeGusta(0);
		respuesta.setSender(usuario);
		respuesta.setTema(this.temaDao.getById(idTema));
		respuesta.setTexto(texto);
		return respuesta;
	}

	public List<RespuestaDTO> getRespuestasDTO(List<Respuesta> respuestas) {
		  List<RespuestaDTO> respuestasDTO = new ArrayList<RespuestaDTO>();
		  for(int i = 0 ; i < respuestas.size(); i++){
			  respuestasDTO.add(this.createRespuestaDTO(respuestas.get(i), i));
		  }
		  return respuestasDTO;
	}
	
	private RespuestaDTO createRespuestaDTO(Respuesta respuesta, Integer numRespuesta ){
		RespuestaDTO resp = new RespuestaDTO();
		resp.setCantidadDeMensajes(this.respuestaDao.getCountByUser(respuesta.getSender().getId()).toString());
		resp.setFechaDeIngreso(DateUtils.formatearFecha(respuesta.getSender().getFecha()));
		resp.setFechaRespuesta(DateUtils.formatearFecha(respuesta.getFecha()));
		resp.setNumero(numRespuesta.toString());
		resp.setSenderUser(respuesta.getSender().getUser());
		resp.setTexto(respuesta.getTexto());
		resp.setTitulo(respuesta.getTema().getTitulo());
		resp.setUbicacion(respuesta.getSender().getUbicacion());
		
		return resp;
	}

}
