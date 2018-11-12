package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ImagenDAO;
import negocio.Imagen;
import negocio.Usuario;

public class AdminsitradorImagen {
	
	private AdminsitradorImagen() {}

	private static AdminsitradorImagen instancia;

	public static AdminsitradorImagen getInstancia() {
		if (instancia == null) {
			instancia = new AdminsitradorImagen();
		}
		return instancia;
	}

	public List<Imagen> getImagenes() {
		 List<Imagen> imagenes = ImagenDAO.getInstancia().listaImagenes();

	return null;
	}
}
