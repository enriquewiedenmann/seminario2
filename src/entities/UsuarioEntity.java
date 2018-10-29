package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class UsuarioEntity {
	
	private String apodo;
	@Id
	private String email;
	private String password;
	private String loggedSession;
	
	
	public UsuarioEntity(String apodo, String email, String password, String loggedSession) {
		this.apodo = apodo;
		this.email = email;
		this.password = password;
		
		this.loggedSession = loggedSession;
	}
	public UsuarioEntity(String apodo) {
		this.apodo = apodo;
	}
	public UsuarioEntity() {
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
	
	
	
}
