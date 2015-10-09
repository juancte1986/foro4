package ar.edu.uces.progweb2.springmvc.bo;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dto.EstadisticasDTO;

public interface EstadisticaBO {

	EstadisticasDTO getEstadisticas() throws BackendException;

}
