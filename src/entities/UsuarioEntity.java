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
	
	private String usuario;
	@Id
	private String email;
	private String pass;
	
	
	public UsuarioEntity(String apodo, String email, String password) {
		this.usuario = apodo;
		this.email = email;
		this.pass = password;
		
	}
	public UsuarioEntity(String apodo) {
		this.usuario = apodo;
	}
	public UsuarioEntity() {
	}
	public String getApodo() {
		return usuario;
	}
	public void setApodo(String apodo) {
		this.usuario = apodo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String password) {
		this.pass = password;
	}

	
	
}
