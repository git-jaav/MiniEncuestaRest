package pe.jaav.sistemas.miniencuesta.model.dao;
 
import java.util.List;
import org.hibernate.Criteria;

import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaAlternativa;

public interface MeEncuestaAlternativaDao extends AbstractDao<MeEncuestaAlternativa, Integer> {
	public int guardar(MeEncuestaAlternativa objDao);
	public int contarListado(MeEncuestaAlternativa objDao);
	public List<MeEncuestaAlternativa> listar(MeEncuestaAlternativa objDao,boolean paginable);
	public Criteria getCriteriaFilter(Object objDaoGen);
}
