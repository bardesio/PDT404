package com.entidades;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
@Table(name = "FENOMENOS")
public class Usuario implements Serializable{

    
	@SequenceGenerator(name="SEQ_FENOMENOID", initialValue=1, allocationSize=100)
    private static final long serialVersionUID = 1L;
    public Fenomeno() {
        // TODO Auto-generated constructor stub
    }

    @Id
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIOID"  )// ver como funciona los trigger.
   
    @Column(name="ID_FENOMENO")
    private Long id;
    
    @Column(name="DESCRIPCION", length=100)
    private String descripcion;
    
    @Column(name="NOMBRE", length=40)
    private String nombre;
 
   
	public Usuario(Long id, String descripcion, String nombre) {
		super();
		
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}
    
	public TipoUsuario getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
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


