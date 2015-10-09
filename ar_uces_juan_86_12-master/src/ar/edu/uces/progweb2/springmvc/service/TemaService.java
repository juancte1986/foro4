package ar.edu.uces.progweb2.springmvc.service;

import java.util.List;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.TemaDTO;
import ar.edu.uces.progweb2.springmvc.model.Tema;

public interface TemaService {
	
	public List<Tema> getTemas(Long idGenero) throws BackendException;

	public List<TemaDTO> getTemasDTO(Long idGenero)throws BackendException;
}
