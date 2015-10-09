package ar.edu.uces.progweb2.springmvc.dao;

import java.util.List;

import ar.edu.uces.progweb2.springmvc.model.Tema;

public interface TemaDao extends GenericDao<Tema> {
	
	public Long getCountTemaByGenero(Long idGenero);
	public List<Tema> getTemasByGenero(Long idGenero);
}
