package com.dao;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entidades.*;


@Stateless
public class UsuarioDao {

		
		@PersistenceContext
		private EntityManager em;
		
	public void AgregarUsuario(Usuario usuario,Long id_tipo) throws Exception 
		{
		try {
				Usuario usuarionuevo= new Usuario();
				usuarionuevo.setUsuario(usuario);
				usuarionuevo.setTipousuario(em.find(TipoUsuario.class,id_tipo ));
				
				this.em.flush();
		}catch(PersistenceException e)
		{
			throw new Exception ("No se pudo crear el usuario.");
		}
		}
}

		

		
	
		
		
	


