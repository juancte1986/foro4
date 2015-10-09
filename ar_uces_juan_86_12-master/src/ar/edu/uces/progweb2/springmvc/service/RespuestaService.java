package ar.edu.uces.progweb2.springmvc.service;

import java.util.List;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.RespuestaDTO;
import ar.edu.uces.progweb2.springmvc.model.Respuesta;
import ar.edu.uces.progweb2.springmvc.model.Usuario;

public interface RespuestaService {
	
	public List<Respuesta> getRespuestas(Long idTema) throws BackendException;

	public void saveOrUpdate(Usuario usuario, Long idTema, String texto) throws BackendException;

	public List<RespuestaDTO> getRespuestasDTO(long id);
}
