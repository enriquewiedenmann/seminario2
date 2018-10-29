package controller;

import java.util.ArrayList;

import view.UsuarioDTO;
import negocio.Usuario;

import dao.UsuarioDAO;



public class AdministradorUsuario {
	
	private ArrayList<Usuario> usuarios;
	private static AdministradorUsuario instancia;
	
	private AdministradorUsuario() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public static AdministradorUsuario getInstancia() {
		if (instancia == null) {
			instancia = new AdministradorUsuario();
		}
		return instancia;
	}
	
	public void crearUsuario(UsuarioDTO usuario){
		if (! UsuarioDAO.getInstancia().existeJugadorByEmail(usuario.getEmail())) {
			Usuario j = new Usuario(usuario.getApodo(), usuario.getEmail(), usuario.getPassword(), usuario.getLoggedSession());
			j.grabar();
			
		}
	}
	
	public void login(UsuarioDTO usuario){
		Usuario j = this.buscarUsuario(usuario.getEmail());
		if (j != null) {
			if (j.passwordCorrecta(usuario.getPassword())) {
				j.setLoggedSession(usuario.getLoggedSession());
				j.grabar();
			
				
			}
		}
	
	}
	
	public void logout(UsuarioDTO usuario){
		if (this.isLoggedIn(usuario)) {
			Usuario j = this.buscarUsuario(usuario.getEmail());
			usuarios.remove(j);
			j.setLoggedSession(null);
			j.grabar();
			
		}
	}
	
	public boolean isLoggedIn (UsuarioDTO usuario) {
		Usuario j = this.buscarUsuario(usuario.getEmail());
		if (j != null) {
			if (j.getLoggedSession().equals(usuario.getLoggedSession())) return true;
		}
		return false;
		
	}
	
	public Usuario buscarUsuario(String email){
		for (Usuario j : usuarios) {
			if (j.getEmail().equals(email)) {
				j.actualizar();
				return j;
			}
		}
		Usuario j = UsuarioDAO.getInstancia().toNegocio(UsuarioDAO.getInstancia().getJugadorByEmail(email));
		this.usuarios.add(j);
		return j;
	}
	
	public UsuarioDTO buscarUsuarioDTO(String apodo) {
		
		Usuario u = this.buscarUsuario(apodo);
		
				
		return u.toDTO();
	}
	
	
	
	
	
	
	
	
	
}
