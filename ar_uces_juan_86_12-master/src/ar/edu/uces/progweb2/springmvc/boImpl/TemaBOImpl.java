package ar.edu.uces.progweb2.springmvc.boImpl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.uces.progweb2.springmvc.bo.TemaBO;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dao.TemaDao;
import ar.edu.uces.progweb2.springmvc.dto.TemaDTO;
import ar.edu.uces.progweb2.springmvc.model.Tema;
import ar.edu.uces.progweb2.springmvc.transformer.TemaTransformer;

public class TemaBOImpl implements TemaBO{
	
	private TemaDao temaDao;
	private TemaTransformer temaTransformer;
	
	@Autowired
	public void setTemaTransformer(TemaTransformer temaTransformer) {
		this.temaTransformer = temaTransformer;
	}

	@Autowired
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	@Override
	public List<TemaDTO> getTemasDTO(Long idGenero) {
		
	}

	@Override
	public List<Tema> getTemas(Long idGenero) throws BackendException{
		try{
			return this.temaDao.getTemasByGenero(idGenero);
			//hibernet son runtime Exception
		} catch (Exception e) {
			throw new BackendException(e);
		}
	}

}
