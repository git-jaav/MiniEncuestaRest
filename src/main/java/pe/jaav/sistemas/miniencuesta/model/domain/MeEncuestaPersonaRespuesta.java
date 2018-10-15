package pe.jaav.sistemas.miniencuesta.model.domain;


import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the me_encuesta_persona_respuesta database table.
 * 
 */
@Entity
@Table(name="me_encuesta_persona_respuesta")
public class MeEncuestaPersonaRespuesta extends EntidadSup {
	private static final long serialVersionUID = 1L;
	private Long enperEncuestaPersonaId;
	private String enperApellidoMaterno;
	private String enperApellidoNombres;
	private String enperApellidoPaterno;
	private String enperCodigoUsuario;
	private Integer enperEdad;
	private String enperEmail;
	private String enperEstado;
	private Date enperFechaRegistro;
	private String enperLugarTrabajo;
	private String enperNombrecompleto;
	private String enperProfesion;
	private String enperSexo;
	
	private Integer enaltId;
	private MeEncuestaAlternativa meEncuestaAlternativa;

	public MeEncuestaPersonaRespuesta() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="enper_encuesta_persona_id")
	public Long getEnperEncuestaPersonaId() {
		return this.enperEncuestaPersonaId;
	}

	public void setEnperEncuestaPersonaId(Long enperEncuestaPersonaId) {
		this.enperEncuestaPersonaId = enperEncuestaPersonaId;
	}


	@Column(name="enper_apellido_materno")
	public String getEnperApellidoMaterno() {
		return this.enperApellidoMaterno;
	}

	public void setEnperApellidoMaterno(String enperApellidoMaterno) {
		this.enperApellidoMaterno = enperApellidoMaterno;
	}


	@Column(name="enper_apellido_nombres")
	public String getEnperApellidoNombres() {
		return this.enperApellidoNombres;
	}

	public void setEnperApellidoNombres(String enperApellidoNombres) {
		this.enperApellidoNombres = enperApellidoNombres;
	}


	@Column(name="enper_apellido_paterno")
	public String getEnperApellidoPaterno() {
		return this.enperApellidoPaterno;
	}

	public void setEnperApellidoPaterno(String enperApellidoPaterno) {
		this.enperApellidoPaterno = enperApellidoPaterno;
	}


	@Column(name="enper_codigo_usuario")
	public String getEnperCodigoUsuario() {
		return this.enperCodigoUsuario;
	}

	public void setEnperCodigoUsuario(String enperCodigoUsuario) {
		this.enperCodigoUsuario = enperCodigoUsuario;
	}


	@Column(name="enper_edad")
	public Integer getEnperEdad() {
		return this.enperEdad;
	}

	public void setEnperEdad(Integer enperEdad) {
		this.enperEdad = enperEdad;
	}


	@Column(name="enper_email")
	public String getEnperEmail() {
		return this.enperEmail;
	}

	public void setEnperEmail(String enperEmail) {
		this.enperEmail = enperEmail;
	}


	@Column(name="enper_estado")
	public String getEnperEstado() {
		return this.enperEstado;
	}

	public void setEnperEstado(String enperEstado) {
		this.enperEstado = enperEstado;
	}


	@Column(name="enper_fecha_registro")
	public Date getEnperFechaRegistro() {
		return this.enperFechaRegistro;
	}

	public void setEnperFechaRegistro(Date enperFechaRegistro) {
		this.enperFechaRegistro = enperFechaRegistro;
	}


	@Column(name="enper_lugar_trabajo")
	public String getEnperLugarTrabajo() {
		return this.enperLugarTrabajo;
	}

	public void setEnperLugarTrabajo(String enperLugarTrabajo) {
		this.enperLugarTrabajo = enperLugarTrabajo;
	}


	@Column(name="enper_nombrecompleto")
	public String getEnperNombrecompleto() {
		return this.enperNombrecompleto;
	}

	public void setEnperNombrecompleto(String enperNombrecompleto) {
		this.enperNombrecompleto = enperNombrecompleto;
	}


	@Column(name="enper_profesion")
	public String getEnperProfesion() {
		return this.enperProfesion;
	}

	public void setEnperProfesion(String enperProfesion) {
		this.enperProfesion = enperProfesion;
	}


	@Column(name="enper_sexo")
	public String getEnperSexo() {
		return this.enperSexo;
	}

	public void setEnperSexo(String enperSexo) {
		this.enperSexo = enperSexo;
	}

	@Column(name="enalt_id")
	public Integer getEnaltId() {
		return enaltId;
	}


	public void setEnaltId(Integer enaltId) {
		this.enaltId = enaltId;
	}


	//bi-directional many-to-one association to MeEncuestaAlternativa
	@ManyToOne
	@JoinColumn(name="enalt_id", insertable=false, updatable = false)
	public MeEncuestaAlternativa getMeEncuestaAlternativa() {
		return this.meEncuestaAlternativa;
	}

	public void setMeEncuestaAlternativa(MeEncuestaAlternativa meEncuestaAlternativa) {
		this.meEncuestaAlternativa = meEncuestaAlternativa;
	}

}