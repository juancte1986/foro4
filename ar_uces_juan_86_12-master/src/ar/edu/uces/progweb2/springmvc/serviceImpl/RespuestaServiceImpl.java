package ar.edu.uces.progweb2.springmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uces.progweb2.springmvc.bo.RespuestaBO;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.RespuestaDTO;
import ar.edu.uces.progweb2.springmvc.model.Respuesta;
import ar.edu.uces.progweb2.springmvc.model.Usuario;
import ar.edu.uces.progweb2.springmvc.service.RespuestaService;

@Service("respuestaService")
public class RespuestaServiceImpl implements RespuestaService {
	
	private RespuestaBO respuestaBO;
	
	@Autowired
	public void setRespuestaBO(RespuestaBO respuestaBO) {
		this.respuestaBO = respuestaBO;
	}
	
	@Override
	public List<Respuesta> getRespuestas(Long idTema) throws BackendException {
		return this.respuestaBO.getRespuestas(idTema);
	}

	@Override
	public void saveOrUpdate(Usuario usuario, Long idTema, String texto) throws BackendException {
		this.respuestaBO.saveOrUpdate(usuario, idTema, texto);
	}

	@Override
	public List<RespuestaDTO> getRespuestasDTO(long id) {
		return this.respuestaBO.getRespuestasDTO(id);
	}
	
}
