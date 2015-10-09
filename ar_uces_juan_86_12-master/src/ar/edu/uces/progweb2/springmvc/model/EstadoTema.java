package ar.edu.uces.progweb2.springmvc.model;

//Java Beab de estado tema solo get y set y contructor vacio
public class EstadoTema {
	
	private Long id;
	private String descripcion;
	
	public EstadoTema() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
