package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Food implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5708450552257017635L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private long id;
	@Column
	@NotBlank
	@Size(min = 1,max = 30,message = "el tamaño del nombre es muy grande")
	@Pattern(regexp = "[a-zA-Z]+",message = "el nombre de la comida tiene simbolos o numeros")
	private String nombre;
	@Column
	@NotBlank
	@Min(1)
	@Max(300)
	private String precio;
	@Column
	@NotBlank
	@Size(max=255)
	private String descricion;
	@Column
	private String categoria;
	@Column
	@Size(max = 10)
	private String ingredientes;
	@Column
	//@NotBlank
	private String diasDisponibles;
	@Column
	@Min(1)
	@Max(20)
	private String CantidadPorciones;
	@Column
	private String imagen;
	
	public Food() {}

	
	public Food(long id, String nombre, String precio, String descricion, String categoria, String ingredientes,
			String diasDisponibles, String cantidadPorciones, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descricion = descricion;
		this.categoria = categoria;
		this.ingredientes = ingredientes;
		this.diasDisponibles = diasDisponibles;
		CantidadPorciones = cantidadPorciones;
		this.imagen = imagen;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
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

	public String getCantidadPorciones() {
		return CantidadPorciones;
	}

	public void setCantidadPorciones(String cantidadPorciones) {
		CantidadPorciones = cantidadPorciones;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CantidadPorciones == null) ? 0 : CantidadPorciones.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descricion == null) ? 0 : descricion.hashCode());
		result = prime * result + ((diasDisponibles == null) ? 0 : diasDisponibles.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((ingredientes == null) ? 0 : ingredientes.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (CantidadPorciones == null) {
			if (other.CantidadPorciones != null)
				return false;
		} else if (!CantidadPorciones.equals(other.CantidadPorciones))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descricion == null) {
			if (other.descricion != null)
				return false;
		} else if (!descricion.equals(other.descricion))
			return false;
		if (diasDisponibles == null) {
			if (other.diasDisponibles != null)
				return false;
		} else if (!diasDisponibles.equals(other.diasDisponibles))
			return false;
		if (id != other.id)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (ingredientes == null) {
			if (other.ingredientes != null)
				return false;
		} else if (!ingredientes.equals(other.ingredientes))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descricion=" + descricion
				+ ", categoria=" + categoria + ", ingredientes=" + ingredientes + ", diasDisponibles=" + diasDisponibles
				+ ", CantidadPorciones=" + CantidadPorciones + ", imagen=" + imagen + "]";
	}
	
	
	
	
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="food_photo"
		,joinColumns=@JoinColumn(name="food_id")
		,inverseJoinColumns=@JoinColumn(name="photo_id"))
	*/
	
	

}
