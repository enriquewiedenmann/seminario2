package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class UsuarioDTO extends JsonDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -56976297441829991L;
	/**
	 * 
	 */
	private int id;
	private String apodo;
	private String email;
	private String password;

	private String loggedSession;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String apodo, String email, String password) {
		super();
		this.apodo = apodo;
		this.email = email;
		this.password = password;

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
		return "UsuarioDTO [apodo=" + apodo + ", email=" + email + ", password=" + password + ", loggedSession="
				+ loggedSession + "]";
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return getJson(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}