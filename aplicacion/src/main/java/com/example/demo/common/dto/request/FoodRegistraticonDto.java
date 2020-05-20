package com.example.demo.common.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class FoodRegistraticonDto {
	@Column
	@NotBlank
	@Size(min = 1,max = 30,message = "el tamaño del nombre es muy grande")
	@Pattern(regexp = "[a-zA-Z]+",message = "el nombre de la comida tiene simbolos o numeros")
	private String nombre;
	@Column
	@NonNull
	@Min(1)
	@Max(300)
	private int precio;
	@Column
	@NotBlank
	@Size(min=10,max=2000,message = "este campo tiene que tener como minimo 10 caracteres")
	private String descricion;
	@Column
	private String categoria;
	@Column
	@NotBlank
	@Size(min=3,max = 255)
	private String ingredientes;
	@Column
	@NotBlank
	private String diasDisponibles;
	@Column
	@Min(1)
	@Max(20)
	private int CantidadPorciones;
	@Column
	private String imagen;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescricion() {
		return descricion;
	}
	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getDiasDisponibles() {
		return diasDisponibles;
	}
	public void setDiasDisponibles(String diasDisponibles) {
		this.diasDisponibles = diasDisponibles;
	}
	public int getCantidadPorciones() {
		return CantidadPorciones;
	}
	public void setCantidadPorciones(int cantidadPorciones) {
		CantidadPorciones = cantidadPorciones;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
