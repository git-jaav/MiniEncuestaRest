package pe.jaav.sistemas.miniencuesta.model.dao.impl;
 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pe.jaav.sistemas.miniencuesta.model.dao.MeEncuestaPersonaRespuestaDao;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaPersonaRespuesta;
import pe.jaav.sistemas.miniencuesta.utiles.UtilesCommons;
 
@Repository
public class MeEncuestaPersonaRespuestaDaoImpl extends AbstractDaoImpl<MeEncuestaPersonaRespuesta, Long> implements MeEncuestaPersonaRespuestaDao {
	protected  MeEncuestaPersonaRespuestaDaoImpl() {
		super(MeEncuestaPersonaRespuesta.class);
	}
 
	public long guardar(MeEncuestaPersonaRespuesta objDao) {
		Object result = getCurrentSession().save(objDao);
		return (long) (result!=null?result:0);
	}
 
	public int contarListado(MeEncuestaPersonaRespuesta objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
 
	@SuppressWarnings("unchecked")
	public List<MeEncuestaPersonaRespuesta> listar(MeEncuestaPersonaRespuesta objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);
		}
		return criteria.list();
	}
 
	public Criteria getCriteriaFilter(Object objDaoGen){
		Criteria criteria = null;
		if(objDaoGen instanceof MeEncuestaPersonaRespuesta){
			MeEncuestaPersonaRespuesta objDao = (MeEncuestaPersonaRespuesta)objDaoGen;
			criteria = getCurrentSession().createCriteria(MeEncuestaPersonaRespuesta.class);
			if (objDao.getMeEncuestaAlternativa() != null) {
				criteria.createAlias("meEncuestaAlternativa", "meEncuestaAlternativa");
				
				if (UtilesCommons.noEsVacio(objDao.getMeEncuestaAlternativa().getEnteCodigo())) {
					criteria.add(Restrictions.eq("meEncuestaAlternativa.enteCodigo",
							objDao.getMeEncuestaAlternativa().getEnteCodigo()));
				}
			}
			if (UtilesCommons.noEsVacio(objDao.getEnaltId())) {
				criteria.add(Restrictions.eq("enaltId", objDao.getEnaltId()));
			}
			if (UtilesCommons.noEsVacio(objDao.getEnperCodigoUsuario())) {
				criteria.add(Restrictions.eq("enperCodigoUsuario", objDao.getEnperCodigoUsuario()));
			}
		}
		return criteria;
	}
}
