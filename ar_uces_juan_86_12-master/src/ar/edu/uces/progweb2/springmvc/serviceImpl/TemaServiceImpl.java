package ar.edu.uces.progweb2.springmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uces.progweb2.springmvc.bo.TemaBO;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.TemaDTO;
import ar.edu.uces.progweb2.springmvc.model.Tema;
import ar.edu.uces.progweb2.springmvc.service.TemaService;

@Service("temaService")
public class TemaServiceImpl implements TemaService{
	
	private TemaBO temaBO;

	
	@Autowired
	public void setTemaBO(TemaBO temaBO) {
		this.temaBO = temaBO;
	}

	@Override
	public List<Tema> getTemas(Long idGenero) throws BackendException {
		return this.temaBO.getTemas(idGenero);
	}

	@Override
	public List<TemaDTO> getTemasDTO(Long idGenero) throws BackendException {
		return this.temaBO.getTemasDTO(idGenero);
	}
	
}
