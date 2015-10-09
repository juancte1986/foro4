package ar.edu.uces.progweb2.springmvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uces.progweb2.springmvc.bo.EstadisticaBO;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dao.RespuestaDao;
import ar.edu.uces.progweb2.springmvc.dao.TemaDao;
import ar.edu.uces.progweb2.springmvc.dao.UsuarioDao;
import ar.edu.uces.progweb2.springmvc.dto.EstadisticasDTO;
import ar.edu.uces.progweb2.springmvc.service.EstadisticaService;

@Service("estadisticaService")
public class EstadisticaServiceImpl implements EstadisticaService{
	
	@Autowired
	private EstadisticaBO estadisticaBO;

	@Override
	public EstadisticasDTO getEstadisticas() throws BackendException {
		return this.estadisticaBO.getEstadisticas();
	}

}
