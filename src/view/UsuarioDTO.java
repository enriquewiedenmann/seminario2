package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class UsuarioDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -56976297441829991L;
	/**
	 * 
	 */

	private String apodo;
	private String email;
	private String password;
	
	private String loggedSession;

	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoggedSession() {
		return loggedSession;
	}

	public void setLoggedSession(String loggedSession) {
		this.loggedSession = loggedSession;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [apodo=" + apodo + ", email=" + email
				+ ", password=" + password + ", loggedSession=" + loggedSession
				+ "]";
	}
	
	
	
	
}