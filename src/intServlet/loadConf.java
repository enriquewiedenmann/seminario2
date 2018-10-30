package intServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import controller.HibernateUtil;

public class loadConf extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6504295291620741361L;

	public void init() throws ServletException {

		new HibernateUtil().getSessionFactory();
	}
}
