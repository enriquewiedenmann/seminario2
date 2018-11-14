package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import entities.ImagenEntity;
import entities.UsuarioImagenEntity;
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

			imagenes.add(toNegocio(imagenEntity));

		}

		return imagenes;
	}

	public ImagenEntity buscarImagen(Integer idImagen) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ImagenEntity imagenEnt = (ImagenEntity) session.createQuery("from ImagenEntity where idImagen = ?")
				.setParameter(0, idImagen).uniqueResult();
		session.close();
		
		return imagenEnt;
	}

	public Imagen toNegocio(ImagenEntity ime) {
		Imagen im = new Imagen();

		im.setLabel(ime.getLabel());
		im.setNombre(ime.getNombre());
		im.setIdImagen(ime.getId());

		return im;
	}

}
