package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import entities.ImagenEntity;
import entities.UsuarioEntity;
import negocio.Imagen;

public class ImagenDAO {

	private static ImagenDAO instancia;

	private ImagenDAO() {
	}

	public static ImagenDAO getInstancia() {
		if (instancia == null) {
			instancia = new ImagenDAO();
		}
		return instancia;
	}

	public List<Imagen> listaImagenes() {

		List<Imagen> imagenes = new ArrayList<>();

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<ImagenEntity> listImg = (List<ImagenEntity>) session.createQuery("from ImagenEntity").list();

		session.close();

		for (ImagenEntity imagenEntity : listImg) {
			Imagen im = new Imagen();
			
			im.setLabel(imagenEntity.getLabel());
			im.setNombre(imagenEntity.getNombre());
			im.setIdImagen(imagenEntity.getId());
			imagenes.add(im);
			
		}

		return imagenes;
	}
}
