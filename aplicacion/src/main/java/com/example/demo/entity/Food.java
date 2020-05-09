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
	@Size(min = 30)
	@Pattern(regexp = "[A-Za-z]")
	private String nombre;
	@Column
	@NotBlank
	@Min(1)
	@Max(500)
	private byte precio;
	@Column
	private String descricion;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="food_category"
		,joinColumns=@JoinColumn(name="food_id")
		,inverseJoinColumns=@JoinColumn(name="category_id"))
	
	private Set<Category> categoria;
	@Column
	private String ingredientes;
	@Column
	@NotBlank
	private String diasDisponibles;
	@Column
	@Min(1)
	@Max(20)
	private byte CantidadPorciones;
	@Column
	private String imagen;
	
	public Food() {}
	
	
	
	
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="food_photo"
		,joinColumns=@JoinColumn(name="food_id")
		,inverseJoinColumns=@JoinColumn(name="photo_id"))
	*/
	
	

}
