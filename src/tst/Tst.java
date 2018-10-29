package tst;

import view.UsuarioDTO;
import controller.AdministradorUsuario;

public class Tst {

	public static void main(String[] args) {
		System.out.println("arrancamos");
		
		
		AdministradorUsuario au = AdministradorUsuario.getInstancia();
		
		UsuarioDTO ud = new UsuarioDTO();
		ud.setApodo("kike");
		ud.setEmail("enrique.wiedenmann@gmail.com");
		ud.setPassword("donboso");
		ud.setLoggedSession("SessionID");
		au.crearUsuario(ud);
		
		au.login(ud);
		System.out.println(au.isLoggedIn(ud));
		au.logout(ud);
		System.out.println(au.isLoggedIn(ud));

	}

}
