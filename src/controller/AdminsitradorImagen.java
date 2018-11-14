package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ImagenDAO;
import dao.ImagenUsuarioDAO;
import negocio.Imagen;
import negocio.Usuario;
import view.ImagenDTO;

public class AdminsitradorImagen {

	private AdminsitradorImagen() {
	}

	private static AdminsitradorImagen instancia;

	public static AdminsitradorImagen getInstancia() {
		if (instancia == null) {
			instancia = new AdminsitradorImagen();
		}
		return instancia;
	}

	public List<ImagenDTO> getImagenes() {
		List<Imagen> list = ImagenDAO.getInstancia().listaImagenes();

		List<ImagenDTO> resp = new ArrayList<>();

		for (Imagen im : list) {
			resp.add(new ImagenDTO(im.getIdImagen(), im.getNombre().trim(), im.getLabel().trim()));
		}

		return resp;
	}

	public void guardarImagenLike(Integer idImagen, Integer idUs) {

		ImagenUsuarioDAO.getInstancia().guardarImagenLike(idImagen, idUs);
	}
}
