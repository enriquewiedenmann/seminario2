package entities;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "UsuarioImagen")
public class UsuarioImagenEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuarioImagen;
	
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@ManyToOne
	@JoinColumn(name = "idImagen")
	private ImagenEntity imagen;

	
	private boolean recomendado;

	@OneToOne
	@JoinColumn(name = "reservadoPor")
	private UsuarioEntity reservadoPor;
	
	
	public void setId(Integer id) {
		this.idUsuarioImagen = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public ImagenEntity getIdImagen() {
		return imagen;
	}

	public void setImagen(ImagenEntity imagen) {
		this.imagen = imagen;
	}

	public boolean isRecomendado() {
		return recomendado;
	}

	public void setRecomendado(boolean recomendado) {
		this.recomendado = recomendado;
	}

	public UsuarioEntity getReservadoPor() {
		return reservadoPor;
	}

	public void setReservadoPor(UsuarioEntity reservadoPor) {
		this.reservadoPor = reservadoPor;
	}

	@Override
	public String toString() {
		return "UsuarioImagenEntity [idUsuarioImagen=" + idUsuarioImagen
				+ ", usuario=" + usuario + ", imagen=" + imagen
				+ ", recomendado=" + recomendado + ", reservadoPor="
				+ reservadoPor + "]";
	}

	
	
	
}
