package pe.jaav.sistemas.miniencuesta.model.domain;


import javax.persistence.*;


/**
 * The persistent class for the me_encuesta_tema database table.
 * 
 */
@Entity
@Table(name="me_encuesta_tema")
@NamedQuery(name="MeEncuestaTema.findAll", query="SELECT m FROM MeEncuestaTema m")
public class MeEncuestaTema extends EntidadSup {
	private static final long serialVersionUID = 1L;
	private Integer enteId;
	private String enteDetalles;
	private String enteEstado;
	private String enteTema;

	public MeEncuestaTema() {
	}


	@Id
	@Column(name="ente_id")
	public Integer getEnteId() {
		return this.enteId;
	}

	public void setEnteId(Integer enteId) {
		this.enteId = enteId;
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