package view;

public class ImagenDTO extends JsonDTO{
	private Integer idImagen;

	private String nombre;
	private String label;
	private String para;

	public ImagenDTO(Integer idImagen, String nombre, String label) {

		this.idImagen = idImagen;
		this.nombre = nombre;
		this.label = label;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
	
	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return getJson(this);
	}

	@Override
	public String toString() {
		return "ImagenDTO [idImagen=" + idImagen + ", nombre=" + nombre
				+ ", label=" + label + ", para=" + para + "]";
	}
	
	

}
