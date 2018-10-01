package pe.jaav.sistemas.miniencuesta.model.domain;

import javax.persistence.*;

/**
 * The persistent class for the me_encuesta_alternativa database table.
 * 
 */
@Entity
@Table(name="me_encuesta_alternativa")
@NamedQuery(name="MeEncuestaAlternativa.findAll", query="SELECT m FROM MeEncuestaAlternativa m")
public class MeEncuestaAlternativa extends EntidadSup {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer enaltId;
	private String enaltEstado;
	private String enaltOpcion;
	
	private Integer enteId;
	
	private MeEncuestaTema meEncuestaTema;	

	public MeEncuestaAlternativa() {
	}


	@Id
	@Column(name="enalt_id")
	public Integer getEnaltId() {
		return this.enaltId;
	}

	public void setEnaltId(Integer enaltId) {
		this.enaltId = enaltId;
	}


	@Column(name="enalt_estado")
	public String getEnaltEstado() {
		return this.enaltEstado;
	}

	public void setEnaltEstado(String enaltEstado) {
		this.enaltEstado = enaltEstado;
	}


	@Column(name="enalt_opcion")
	public String getEnaltOpcion() {
		return this.enaltOpcion;
	}

	public void setEnaltOpcion(String enaltOpcion) {
		this.enaltOpcion = enaltOpcion;
	}


	@Column(name="ente_id")
	public Integer getEnteId() {
		return enteId;
	}


	public void setEnteId(Integer enteId) {
		this.enteId = enteId;
	}


	//bi-directional many-to-one association to MeEncuestaTema
	@ManyToOne
	@JoinColumn(name="ente_id", insertable = false, updatable = false)
	public MeEncuestaTema getMeEncuestaTema() {
		return this.meEncuestaTema;
	}

	public void setMeEncuestaTema(MeEncuestaTema meEncuestaTema) {
		this.meEncuestaTema = meEncuestaTema;
	}

}