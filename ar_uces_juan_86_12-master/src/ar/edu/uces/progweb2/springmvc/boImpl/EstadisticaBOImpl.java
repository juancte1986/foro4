package ar.edu.uces.progweb2.springmvc.boImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.uces.progweb2.springmvc.bo.EstadisticaBO;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dao.RespuestaDao;
import ar.edu.uces.progweb2.springmvc.dao.TemaDao;
import ar.edu.uces.progweb2.springmvc.dao.UsuarioDao;
import ar.edu.uces.progweb2.springmvc.dto.EstadisticasDTO;
import ar.edu.uces.progweb2.springmvc.transformer.TransformerEstadistica;

@Component
public class EstadisticaBOImpl implements EstadisticaBO{
	
	private TransformerEstadistica transformer;
	private TemaDao temaDao;
	private RespuestaDao respuestaDao;
	private UsuarioDao usuarioDao;
	
	@Autowired
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	@Autowired
	public void setRespuestaDao(RespuestaDao respuestaDao) {
		this.respuestaDao = respuestaDao;
	}
	
	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Autowired
	public void setTransformer(TransformerEstadistica transformer) {
		this.transformer = transformer;
	}

	@Override
	public EstadisticasDTO getEstadisticas() throws BackendException {
		try{
			Long numTemas = this.temaDao.getCount();
			Long numRespuestas = this.respuestaDao.getCount();
			Long numUsuarios = this.usuarioDao.getCount();
			Long numJava = this.temaDao.getCountTemaByGenero(new Long("1"));
			Long numPhp = this.temaDao.getCountTemaByGenero(new Long("2"));
			Long numNet = this.temaDao.getCountTemaByGenero(new Long("3"));
			Long numC = this.temaDao.getCountTemaByGenero(new Long("4"));
			
			return this.transformer.transformarResult(numTemas, numRespuestas, numUsuarios, numJava, numNet, numPhp, numC);
		} catch (Exception e) {
			throw new BackendException(e);
		}
	}
}
