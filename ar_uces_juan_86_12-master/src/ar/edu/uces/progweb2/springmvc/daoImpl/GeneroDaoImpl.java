package ar.edu.uces.progweb2.springmvc.daoImpl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.springmvc.model.Genero;

@Transactional(readOnly = true)
@Component
public class GeneroDaoImpl extends GenericDaoImpl<Genero>{
	
}
