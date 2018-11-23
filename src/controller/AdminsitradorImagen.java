package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ImagenDAO;
import dao.ImagenUsuarioDAO;
import dao.UsuarioDAO;
import entities.ImagenEntity;
import negocio.Imagen;
import negocio.Usuario;
import view.ImagenDTO;
import view.UsuarioDTO;

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

	public void reservarRegalo(Integer idImagen , Integer idUs, String agasajdo) {

		ImagenUsuarioDAO.getInstancia().ReservarRegalo(idImagen ,idUs,agasajdo);
	}		
	
	
	public List<ImagenDTO> getImagenesLike(String email) {
		UsuarioDTO us = UsuarioDAO.getInstancia().buscarUsuarioByApodo(email);
		List<Imagen> list = ImagenUsuarioDAO.getInstancia().buscarImagenLike(us);


		
		
		List<ImagenDTO> resp = new ArrayList<>();

		for (Imagen im : list) {
			resp.add(new ImagenDTO(im.getIdImagen(), im.getNombre().trim(), im.getLabel().trim()));
		}

		return resp;

	}

	
	
	public List<ImagenDTO> getImagenesReserva(Integer idUs) {
		
		List<Imagen> list = ImagenUsuarioDAO.getInstancia().buscarReservados(idUs);


		
		
		List<ImagenDTO> resp = new ArrayList<ImagenDTO>();

		for (Imagen im : list) {
			ImagenDTO dto =	new ImagenDTO(im.getIdImagen(), im.getNombre().trim(), im.getLabel().trim());
			dto.setPara(im.getPara());
			
			resp.add(dto);
		}

		return resp;

	}
	
	
	public ImagenEntity buscarImagen(Integer idImagen) {
		// TODO Auto-generated method stub
		return ImagenDAO.getInstancia().buscarImagen(idImagen);
	}
}
