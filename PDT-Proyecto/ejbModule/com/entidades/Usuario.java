package com.entidades;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Session Bean implementation class Usuario
 */
@Entity

public class Usuario implements UsuarioRemote {

    
    
    private static final long serialVersionUID = 1L;
    public Usuario() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)// ver como funciona los trigger.
    @Column(name="ID_USUARIO",length=50,unique=true)
    private Long id;
    @Column(name="PASS", length=30, nullable=true)
    private String pass;
    
    
    
    
    
    
    
    
    
    
    
    
}
