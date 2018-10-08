package pe.jaav.sistemas.miniencuesta.model.dao;
 
import java.util.List;
import org.hibernate.Criteria;

import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaPersonaRespuesta;

public interface MeEncuestaPersonaRespuestaDao extends AbstractDao<MeEncuestaPersonaRespuesta, Long> {
	public long guardar(MeEncuestaPersonaRespuesta objDao);
	public int contarListado(MeEncuestaPersonaRespuesta objDao);
	public List<MeEncuestaPersonaRespuesta> listar(MeEncuestaPersonaRespuesta objDao,boolean paginable);
	public Criteria getCriteriaFilter(Object objDaoGen);
}
