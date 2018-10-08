package pe.jaav.sistemas.miniencuesta.service;

import java.util.List;

import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaPersonaRespuesta;

public interface MeEncuestaPersonaRespuestaService {

	public MeEncuestaPersonaRespuesta obtenerPorId(Long id);
	public int contarListado(MeEncuestaPersonaRespuesta objDao);
	public List<MeEncuestaPersonaRespuesta> listar(MeEncuestaPersonaRespuesta objDao,boolean paginable);
	
	public long guardar(MeEncuestaPersonaRespuesta objDao);
	public int actualizar(MeEncuestaPersonaRespuesta objDao);
	public int eliminar(MeEncuestaPersonaRespuesta objDao);
	
}
