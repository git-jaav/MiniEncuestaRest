package pe.jaav.sistemas.miniencuesta.service;

import java.util.List;

import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaTema;

public interface MeEncuestaTemaService {

	public MeEncuestaTema obtenerPorId(Integer id);	
	public int contarListado(MeEncuestaTema objDao);
	public List<MeEncuestaTema> listar(MeEncuestaTema objDao,boolean paginable);
	
	public int guardar(MeEncuestaTema objDao);
	public int actualizar(MeEncuestaTema objDao);
	public int eliminar(MeEncuestaTema objDao);
}
