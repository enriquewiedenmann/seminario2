package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import entities.ImagenUsuarioEntity;

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

		ImagenUsuarioEntity im = new ImagenUsuarioEntity();
		im.setIdImagen(idImagen);
		im.setIdUsuario(idUs);
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
}
