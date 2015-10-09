package ar.edu.uces.progweb2.springmvc.boImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.uces.progweb2.springmvc.bo.RespuestaBO;
import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;
import ar.edu.uces.progweb2.springmvc.dao.RespuestaDao;
import ar.edu.uces.progweb2.springmvc.dto.RespuestaDTO;
import ar.edu.uces.progweb2.springmvc.model.Respuesta;
import ar.edu.uces.progweb2.springmvc.model.Usuario;
import ar.edu.uces.progweb2.springmvc.transformer.TransformerRespuesta;

public class RespuestaBOImpl implements RespuestaBO{
	
	private RespuestaDao respuestaDao;
	private TransformerRespuesta transformerRespuesta;

	@Autowired
	public void setRespuestaDao(RespuestaDao respuestaDao) {
		this.respuestaDao = respuestaDao;
	}

	@Autowired
	public void setTransformerRespuesta(TransformerRespuesta transformerRespuesta) {
		this.transformerRespuesta = transformerRespuesta;
	}


	@Override
	public void saveOrUpdate(Usuario usuario, Long idTema, String texto) throws BackendException{
		try{
			Respuesta respuesta = this.transformerRespuesta.crearRespuesta(usuario, idTema, texto);
			this.respuestaDao.saveOrUpdate(respuesta);
		} catch(Exception e ){
			throw new BackendException(e);
		}
	}

	@Override
	public List<Respuesta> getRespuestas(Long idTema)throws BackendException {
		try{
			return this.respuestaDao.getRespuestas(idTema);
		} catch(Exception e ){
			throw new BackendException(e);
		}
		
	}

	@Override
	public List<RespuestaDTO> getRespuestasDTO(long idTema) {
		List<Respuesta> respuestas = this.respuestaDao.getRespuestas(idTema);
		List<RespuestaDTO> respuestasDTO = this.transformerRespuesta.getRespuestasDTO(respuestas);
		return respuestasDTO;
	}

}
