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
				.createQuery("from UsuarioImagenEntity where idUsuario=? AND reservadoPor is null").setParameter(0, us.getId()).list();

		session.close();

		for (UsuarioImagenEntity imagenEntity : listImg) {

			imagenes.add(ImagenDAO.getInstancia().toNegocio(imagenEntity.getIdImagen()));

		}
		return imagenes;
	}

	public List<Imagen> buscarReservados(Integer us) {
		List<Imagen> imagenes = new ArrayList<>();
	
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<UsuarioImagenEntity> listImg = (List<UsuarioImagenEntity>) session
				.createQuery("from UsuarioImagenEntity where reservadoPor=? ").setParameter(0, us).list();


		session.close();

		for (UsuarioImagenEntity imagenEntity : listImg) {
			
			imagenes.add(ImagenDAO.getInstancia().toNegocio(imagenEntity));

		}
		return imagenes;
	}
	
	
	public void ReservarRegalo(Integer idImagen, Integer idUs, String agasajado) {
		
		UsuarioDTO us = new UsuarioDTO() ;
		us.setId(UsuarioDAO.getInstancia().buscarUsuarioByApodo(agasajado).getId());
		UsuarioImagenEntity im = this.buscarImagenUsuarioByUsuario(us,idImagen);
		UsuarioEntity usResevadoPor = AdministradorUsuario.getInstancia().buscarUsuario(idUs);
		im.setReservadoPor(usResevadoPor);
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(im);

		session.getTransaction().commit();
		session.close();

		
	}

	private UsuarioImagenEntity buscarImagenUsuarioByUsuario(UsuarioDTO us, Integer idImagen) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioImagenEntity UsuarioImagenEntity = (UsuarioImagenEntity) session.createQuery("from UsuarioImagenEntity where idUsuario = ? and idImagen = ?")
				.setParameter(0, us.getId()).setParameter(1, idImagen).uniqueResult();
		session.close();
		
			// pasarla ! a un metodo de busqueda nuevo throw new UsuarioException("El
			// usuario con apodo: " + apodo + "no existe en la base de datos.");
			return UsuarioImagenEntity;
		
	}

}
