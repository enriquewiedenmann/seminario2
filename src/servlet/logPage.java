package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logPage
 */
@WebServlet("/logPage")
public class logPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer rAccion =null;
		try{ rAccion = Integer.parseInt((String)request.getParameter("accion"));}catch(Exception e){};
		System.out.println(rAccion);
		String mail= (String)request.getParameter("email");
		String pass = (String)request.getParameter("pass");
		System.out.println(mail + "   "+pass);
		switch (rAccion) 
		{
		
		case 2:
			System.out.println("logIn");
			System.out.println(mail + "   "+pass);
		case 1:
			System.out.println("sing up");
			
		default:
			System.out.println(mail + "   "+pass);
			System.out.println("devolver a la misma pagina");
		break;
		
		
		}
		
	//	HttpSession session = request.getSession(true);
		//session.setAttribute("intentos",Integer.toString(Integer.parseInt((String)session.getAttribute("intentos"))+1));
	//	System.out.println("secion user:" + session.getAttribute("user"));
	}

}
