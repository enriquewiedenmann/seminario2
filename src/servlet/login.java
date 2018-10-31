package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.AdministradorUsuario;
import utils.HashUtil;
import view.UsuarioDTO;

/**
 * Servlet implementation class logPage
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to
		// the output stream
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will
		// return your json object



		if ((request.getParameter("action") != null) && request.getParameter("action").equals("signUp")) {
			String email = request.getParameter("email");
			String pass = HashUtil.hashString(request.getParameter("pass").trim());
			UsuarioDTO us = AdministradorUsuario.getInstancia().login(email.trim());
			if (us == null) {

				String apodo = request.getParameter("apodo");

				UsuarioDTO newUs = new UsuarioDTO();
				newUs.setApodo(apodo.trim());
				newUs.setEmail(email.trim());
				newUs.setPassword(pass.trim());
				AdministradorUsuario.getInstancia().guardarUsuario(newUs);
				us = AdministradorUsuario.getInstancia().login(email);

				HttpSession session = request.getSession();

				session.setAttribute("userApodo", us.getApodo());
				session.setAttribute("userId", us.getEmail());

				out.print("{\"Error\":\"false\"}");
			} else {
				out.print("{\"Error\":\"true\",\"ErrorMSG\":\"Error el usuario no es valido\"}");
			}
		} else if ((request.getParameter("action") != null) && request.getParameter("action").equals("login")) {
			String email = request.getParameter("email");
			String pass = HashUtil.hashString(request.getParameter("pass").trim());
			UsuarioDTO us = AdministradorUsuario.getInstancia().login(email);
			if ((us != null) && (us.getPassword().equals(pass))) {

				HttpSession session = request.getSession();

				session.setAttribute("userApodo", us.getApodo());
				session.setAttribute("userId", us.getEmail());

				out.print("{\"Error\":\"false\"}");
			} else {
				out.print("{\"Error\":\"true\",\"ErrorMSG\":\"Error el usuario no es valido\"}");
			}
		} else {
			HttpSession session = request.getSession();
			session.invalidate();
			out.print("{}");
		}

		out.flush();
	}

}
