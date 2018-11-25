package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuario;

	private String usuario;
	private String email;
	private String pass;
 
	/*@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="reservadoPor")
	@Transient
	private ArrayList<UsuarioImagenEntity> regalosReservados;
	*/
	public int getId() {
		return idUsuario;
	}

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

	/*public ArrayList<UsuarioImagenEntity> getRegalosReservados() {
		return regalosReservados;
	}

	public void setRegalosReservados(
			ArrayList<UsuarioImagenEntity> regalosReservados) {
		this.regalosReservados = regalosReservados;
	}
*/
}
