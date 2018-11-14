package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonSerializationContext;

import controller.AdministradorUsuario;
import controller.AdminsitradorImagen;
import dao.ImagenDAO;
import entities.ImagenEntity;
import negocio.Imagen;
import utils.HashUtil;
import view.ImagenDTO;
import view.UsuarioDTO;

/**
 * Servlet implementation class logPage
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public main() {
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

		JSONObject resp = new JSONObject();
		UsuarioDTO newUs = new UsuarioDTO();
		HttpSession session = request.getSession();

		try {
			if ((request.getParameter("action") != null) && request.getParameter("action").equals("signUp")) {
				String email = request.getParameter("email");
				String pass = HashUtil.hashString(request.getParameter("pass").trim());
				UsuarioDTO us = AdministradorUsuario.getInstancia().login(email.trim());
				if (us == null) {

					String apodo = request.getParameter("apodo");

					newUs.setApodo(apodo.trim());
					newUs.setEmail(email.trim());
					newUs.setPassword(pass.trim());
					AdministradorUsuario.getInstancia().guardarUsuario(newUs);
					us = AdministradorUsuario.getInstancia().login(email);

					session.setAttribute("userApodo", us.getApodo());
					session.setAttribute("userId", us.getEmail());

					resp.put("Error", false);

				} else {
					resp.put("Error", true);
					resp.put("ErrorMSG", "Error el usuario no es valido");

				}
			} else if ((request.getParameter("action") != null) && request.getParameter("action").equals("login")) {
				String email = request.getParameter("email");
				String pass = HashUtil.hashString(request.getParameter("pass").trim());
				UsuarioDTO us = AdministradorUsuario.getInstancia().login(email);
				if ((us != null) && (us.getPassword().equals(pass))) {

					session.setAttribute("userApodo", us.getApodo());
					session.setAttribute("userId", us.getId());
					resp.put("Error", false);

				} else {
					resp.put("Error", true);
					resp.put("ErrorMSG", "Error el usuario no es valido");
				}
			} else if ((request.getParameter("action") != null) && request.getParameter("action").equals("getImages")) {
				String email = "";

				if (request.getParameter("email") != null) {
					email = request.getParameter("email");
				}
				
				List<ImagenDTO> imagenes = null;
				
				if (email.length()>0)
					 imagenes = AdminsitradorImagen.getInstancia().getImagenesLike(email);
				else
					 imagenes = AdminsitradorImagen.getInstancia().getImagenes();
				
				JSONArray arr = new JSONArray();

				for (ImagenDTO imagenDTO : imagenes) {

					JSONObject jo = new JSONObject(imagenDTO.toJson());

					arr.put(jo);
				}
				resp.put("Imagenes", arr);

			} else if ((request.getParameter("action") != null) && request.getParameter("action").equals("like")) {

				Integer idImagen = Integer.valueOf(request.getParameter("idImagen"));
				Integer idUs = (Integer) session.getAttribute("userId");

				AdminsitradorImagen.getInstancia().guardarImagenLike(idImagen, idUs);

			} else {
				session.invalidate();
				resp.put("Error", true);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(resp.toString());

		out.flush();
	}

}
