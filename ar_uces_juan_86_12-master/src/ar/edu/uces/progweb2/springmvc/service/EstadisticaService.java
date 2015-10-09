package ar.edu.uces.progweb2.springmvc.service;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.EstadisticasDTO;

public interface EstadisticaService {

	public EstadisticasDTO getEstadisticas() throws BackendException;

}
