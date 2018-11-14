package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.AdministradorUsuario;
import controller.AdminsitradorImagen;
import controller.HibernateUtil;
import entities.ImagenEntity;
import entities.UsuarioImagenEntity;
import entities.UsuarioEntity;
import negocio.Imagen;
import view.ImagenDTO;
import view.UsuarioDTO;

public class ImagenUsuarioDAO {

	private static ImagenUsuarioDAO instancia;

	private ImagenUsuarioDAO() {
	}

	public static ImagenUsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new ImagenUsuarioDAO();
		}
		return instancia;
	}

	public void guardarImagenLike(Integer idImagen, Integer idUs) {

		UsuarioImagenEntity im = new UsuarioImagenEntity();

		ImagenEntity imgEnt = AdminsitradorImagen.getInstancia().buscarImagen(idImagen);
		UsuarioEntity usEnt = AdministradorUsuario.getInstancia().buscarUsuario(idUs);

		im.setImagen(imgEnt);
		im.setUsuario(usEnt);
		im.setRecomendado(false);
		im.setId(null);
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(im);

		session.getTransaction().commit();
		session.close();

	}

	public List<Imagen> buscarImagenLike(UsuarioDTO us) {
		List<Imagen> imagenes = new ArrayList<>();

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<UsuarioImagenEntity> listImg = (List<UsuarioImagenEntity>) session
				.createQuery("from UsuarioImagenEntity where idUsuario=?").setParameter(0, us.getId()).list();

		session.close();

		for (UsuarioImagenEntity imagenEntity : listImg) {

			imagenes.add(ImagenDAO.getInstancia().toNegocio(imagenEntity.getIdImagen()));

		}
		return imagenes;
	}

}
