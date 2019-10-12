package com.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FENOMENOS")
public class Fenomeno implements Serializable{

    
	@SequenceGenerator(name="SEQ_FENOMENOID", initialValue=1, allocationSize=100)
    private static final long serialVersionUID = 1L;
    public Fenomeno() {
    	
    }

    @Id
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIOID"  )// ver como funciona los trigger.
   
    @Column(name="ID_FENOMENO")
    private Long id;
    
    @Column(name="DESCRIPCION", length=100)
    private String descripcion;
    
    @Column(name="NOMBRE", length=40)
    private String nombre;
 
   
	public Fenomeno(Long id, String descripcion, String nombre) {
		super();
		
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
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
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Fenomeno [id=" + id + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
	}
	

	}


