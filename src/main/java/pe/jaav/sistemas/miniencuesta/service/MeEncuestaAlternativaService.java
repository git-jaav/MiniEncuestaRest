package pe.jaav.sistemas.miniencuesta.service;

import java.util.List;


import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaAlternativa;

public interface MeEncuestaAlternativaService {

	public MeEncuestaAlternativa obtenerPorId(Integer id);
	public int contarListado(MeEncuestaAlternativa objDao);
	public List<MeEncuestaAlternativa> listar(MeEncuestaAlternativa objDao,boolean paginable);
	
	public int guardar(MeEncuestaAlternativa objDao);
	public int actualizar(MeEncuestaAlternativa objDao);
	public int eliminar(MeEncuestaAlternativa objDao);
	
	
	
}
