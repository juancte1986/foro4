package ar.edu.uces.progweb2.springmvc.dto;

public class TemaDTO {
	
	private String id;
	private String estadoDescripcion;
	private String idEstado;
	private String idGenero;
	private String titulo;
	private String user;
	private String fecha;
	private String visitas;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}
	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getVisitas() {
		return visitas;
	}
	public void setVisitas(String visitas) {
		this.visitas = visitas;
	}
	
}
