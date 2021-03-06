package pe.jaav.sistemas.miniencuesta.model.dao;
 
import java.util.List;

import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaTema;

public interface MeEncuestaTemaDao extends AbstractDao<MeEncuestaTema, String> {
	
	public int contarListado(MeEncuestaTema objDao);
	public List<MeEncuestaTema> listar(MeEncuestaTema objDao,boolean paginable);
	//public Criteria getCriteriaFilter(Object objDaoGen);
}
