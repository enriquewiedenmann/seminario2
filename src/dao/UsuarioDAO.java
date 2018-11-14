package dao;

import java.util.ArrayList;
import java.util.List;

import negocio.Usuario;
import view.UsuarioDTO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import entities.UsuarioEntity;

public class UsuarioDAO {
	private static UsuarioDAO instancia;

	private UsuarioDAO() {
	}

	public static UsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	public UsuarioDTO buscarUsuarioByApodo(String email) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity usuarioEntity = (UsuarioEntity) session.createQuery("from UsuarioEntity where email = ?")
				.setParameter(0, email).uniqueResult();
		session.close();
		if (usuarioEntity != null) {
			return toNegocio(usuarioEntity);
		} else {
			// pasarla ! a un metodo de busqueda nuevo throw new UsuarioException("El
			// usuario con apodo: " + apodo + "no existe en la base de datos.");
			return null;
		}
	}

	public UsuarioDTO toNegocio(UsuarioEntity usuarioEntity) {
		UsuarioDTO usuario = new UsuarioDTO(usuarioEntity.getApodo(), usuarioEntity.getEmail(),
				usuarioEntity.getPassword());
		usuario.setId(usuarioEntity.getId());
		return usuario;
	}

	public void guardarUsuario(UsuarioDTO newUs) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity usuarioEntity = new UsuarioEntity(newUs.getApodo(), newUs.getEmail(), newUs.getPassword());
		session.beginTransaction();
		session.saveOrUpdate(usuarioEntity);
		session.getTransaction().commit();

		session.close();
	}

	public List<UsuarioDTO> buscarAmigos(String email) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<UsuarioEntity> usuarioEntity = (List<UsuarioEntity>) session
				.createQuery("from UsuarioEntity where email like ?").setParameter(0, "%"+email+"%").list();
		session.close();

		List<UsuarioDTO> us = new ArrayList<UsuarioDTO>();

		for (UsuarioEntity e : usuarioEntity) {

			us.add(toNegocio(e));
		}

		return us;
	}

}
