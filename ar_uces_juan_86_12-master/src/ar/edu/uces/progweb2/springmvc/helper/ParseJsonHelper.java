package ar.edu.uces.progweb2.springmvc.helper;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import ar.edu.uces.progweb2.springmvc.bussinesException.BackendException;

@Component
public class ParseJsonHelper<T> {
	
	public String getJson(List<T> lista) throws BackendException{
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(lista);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			throw new BackendException(e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new BackendException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BackendException(e);
		}	
		
	}
}


