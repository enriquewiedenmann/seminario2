package dao;

import java.util.ArrayList;

import negocio.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import entities.UsuarioEntity;




public class UsuarioDAO {
	private static UsuarioDAO instancia;

	private UsuarioDAO() {}
	
	public static UsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}
	
	public UsuarioEntity getJugadorByEmail(String apodo){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity je = (UsuarioEntity) session.createQuery("from UsuarioEntity where email = ?")
				.setParameter(0, apodo)
				.uniqueResult();
		
		return je;
	
	}

	public Usuario toNegocio(UsuarioEntity je) {
		Usuario j = new Usuario(je.getApodo(), je.getEmail(), je.getPassword(), je.getLoggedSession());
		
		return j;
	}
		
	public Usuario toNegocio_grupo(UsuarioEntity je) {
		Usuario j = new Usuario(je.getApodo(), je.getEmail(), je.getPassword(), je.getLoggedSession());
		return j;
	}
	
	public void grabar(Usuario j) {
		UsuarioEntity je = new UsuarioEntity(j.getApodo(), j.getEmail(), j.getPassword(),  j.getLoggedSession());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(je);
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	public void actualizar(Usuario j){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity je = (UsuarioEntity) session.createQuery("from UsuarioEntity where apodo = ?")
				.setParameter(0, j.getApodo())
				.uniqueResult();
		if (je != null) {
			j.setEmail(je.getEmail());
			j.setPassword(je.getPassword());
			j.setLoggedSession(je.getLoggedSession());
		
		}
	
	}
	
	public Boolean existeJugadorByEmail(String mail) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity je = (UsuarioEntity) session.createQuery("from UsuarioEntity where email = ?")
				.setParameter(0, mail)
				.uniqueResult();
		if (je != null) return true;
		else return false;
	}
	
}
