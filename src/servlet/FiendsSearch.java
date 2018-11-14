package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import controller.AdministradorUsuario;
import view.UsuarioDTO;

@WebServlet("/FiendsSearch")

public class FiendsSearch extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7466500979277758108L;

	public FiendsSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		String email = request.getParameter("search");
		PrintWriter out = response.getWriter();

		List<UsuarioDTO> amigos = new ArrayList<>();
		JSONArray resp = new JSONArray();

		if (email.length() > 2) {
			amigos = AdministradorUsuario.getInstancia().buscarAmigos(email);

			for (UsuarioDTO usuarioDTO : amigos) {

				try {
					
					String usrEmail = usuarioDTO.getEmail();
					JSONObject ob = new JSONObject();
					ob.put("email", usrEmail.trim());
					
					resp.put(ob);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		out.print(resp.toString());

		out.flush();

	}

}
