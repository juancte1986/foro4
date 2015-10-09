package ar.edu.uces.progweb2.springmvc.bo;

import java.util.List;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.TemaDTO;
import ar.edu.uces.progweb2.springmvc.model.Tema;

public interface TemaBO {

	List<TemaDTO> getTemasDTO(Long idGenero) throws BackendException;

	List<Tema> getTemas(Long idGenero) throws BackendException;
	
}
