package com.antonypalomino.model;

public class Bodega {
	

	private Integer IdBodega;
	private String nombre;
	private String direccion;
	private Productos idProductos;
	
	
	
	public Bodega(Integer idBodega, String nombre, String direccion, Productos idProductos) {
		super();
		IdBodega = idBodega;
		this.nombre = nombre;
		this.direccion = direccion;
		this.idProductos = idProductos;
	}
	public Integer getIdBodega() {
		return IdBodega;
	}
	public void setIdBodega(Integer idBodega) {
		IdBodega = idBodega;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Productos getIdProductos() {
		return idProductos;
	}
	public void setIdProductos(Productos idProductos) {
		this.idProductos = idProductos;
	}
	
	

}
