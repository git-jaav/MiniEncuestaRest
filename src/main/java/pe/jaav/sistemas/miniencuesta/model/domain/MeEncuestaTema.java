package pe.jaav.sistemas.miniencuesta.model.domain;


import javax.persistence.*;


/**
 * The persistent class for the me_encuesta_tema database table.
 * 
 */
@Entity
@Table(name="me_encuesta_tema")
public class MeEncuestaTema extends EntidadSup {
	private static final long serialVersionUID = 1L;
	private String enteCodigo;
	private String enteDetalles;
	private String enteEstado;
	private String enteTema;

	public MeEncuestaTema() {
	}


	
	@Id
	@Column(name="ente_codigo")	
	public String getEnteCodigo() {
		return enteCodigo;
	}

	public void setEnteCodigo(String enteCodigo) {
		this.enteCodigo = enteCodigo;
	}


	


	@Column(name="ente_detalles")
	public String getEnteDetalles() {
		return this.enteDetalles;
	}

	public void setEnteDetalles(String enteDetalles) {
		this.enteDetalles = enteDetalles;
	}


	@Column(name="ente_estado")
	public String getEnteEstado() {
		return this.enteEstado;
	}

	public void setEnteEstado(String enteEstado) {
		this.enteEstado = enteEstado;
	}


	@Column(name="ente_tema")
	public String getEnteTema() {
		return this.enteTema;
	}

	public void setEnteTema(String enteTema) {
		this.enteTema = enteTema;
	}
}