package negocio;


import view.UsuarioDTO;

import dao.UsuarioDAO;


public class Usuario {
	
	private String apodo;
	private String email;
	private String password;
	private String loggedSession;
	
	

	

	public Usuario(String apodo, String email, String password, String loggedSession) {
		this.apodo = apodo;
		this.email = email;
		this.password = password;
		this.loggedSession = loggedSession;
	
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

	public boolean passwordCorrecta(String password) {
		return (this.password.equals(password));
	}
	
		
	
	public UsuarioDTO toDTO() {
		UsuarioDTO ud = new UsuarioDTO();
		ud.setApodo(this.getApodo());
		ud.setEmail(this.getEmail());
		ud.setLoggedSession(this.getLoggedSession());
		ud.setPassword(this.getPassword());
		return ud;
	}
			
	public void grabar() {
		UsuarioDAO.getInstancia().grabar(this);
	}
	
	public void actualizar() {
		UsuarioDAO.getInstancia().actualizar(this);
	}

	
	}
