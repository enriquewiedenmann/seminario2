package controller;

import java.util.ArrayList;
import java.util.List;

import view.UsuarioDTO;
import negocio.Usuario;

import dao.UsuarioDAO;
import entities.UsuarioEntity;

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


	public UsuarioDTO login(String email) {
		UsuarioDTO u = UsuarioDAO.getInstancia().buscarUsuarioByApodo(email);
		return u;
	}

	public void guardarUsuario(UsuarioDTO newUs) {
		// TODO Auto-generated method stub
		 UsuarioDAO.getInstancia().guardarUsuario(newUs);
	}

	public List<UsuarioDTO> buscarAmigos(String email) {
		// TODO Auto-generated method stub
		return  UsuarioDAO.getInstancia().buscarAmigos(email);
	}

	public UsuarioEntity buscarUsuario(Integer idUs) {
		// TODO Auto-generated method stub
		return  UsuarioDAO.getInstancia().buscarUsuarioById(idUs);
	}

}
