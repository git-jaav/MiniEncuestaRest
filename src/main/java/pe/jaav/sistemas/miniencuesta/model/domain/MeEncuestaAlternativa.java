package pe.jaav.sistemas.miniencuesta.model.domain;

import javax.persistence.*;

/**
 * The persistent class for the me_encuesta_alternativa database table.
 * 
 */
@Entity
@Table(name="me_encuesta_alternativa")
public class MeEncuestaAlternativa extends EntidadSup {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer enaltId;
	private String enaltEstado;
	private String enaltOpcion;
	
	private String enteCodigo;
	
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


	@Column(name="ente_codigo")
	public String getEnteCodigo() {
		return enteCodigo;
	}


	public void setEnteCodigo(String enteCodigo) {
		this.enteCodigo = enteCodigo;
	}


	//bi-directional many-to-one association to MeEncuestaTema
	@ManyToOne
	@JoinColumn(name="ente_codigo", insertable = false, updatable = false)
	public MeEncuestaTema getMeEncuestaTema() {
		return this.meEncuestaTema;
	}

	public void setMeEncuestaTema(MeEncuestaTema meEncuestaTema) {
		this.meEncuestaTema = meEncuestaTema;
	}

}