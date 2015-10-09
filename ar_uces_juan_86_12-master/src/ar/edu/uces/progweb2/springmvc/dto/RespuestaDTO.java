package ar.edu.uces.progweb2.springmvc.dto;

public class RespuestaDTO {
	
	private String titulo;
	private String texto;
	private String fechaRespuesta;
	private String fechaDeIngreso;
	private String ubicacion;
	private String senderUser;
	private String numero;
	private String cantidadDeMensajes;
	
	public RespuestaDTO(){
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getFechaRespuesta() {
		return fechaRespuesta;
	}
	public void setFechaRespuesta(String fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getSenderUser() {
		return senderUser;
	}
	public void setSenderUser(String senderUser) {
		this.senderUser = senderUser;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCantidadDeMensajes() {
		return cantidadDeMensajes;
	}
	public void setCantidadDeMensajes(String cantidadDeMensajes) {
		this.cantidadDeMensajes = cantidadDeMensajes;
	}
	
}
