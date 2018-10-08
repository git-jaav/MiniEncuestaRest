package pe.jaav.sistemas.miniencuesta.model.dao.impl;
 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pe.jaav.sistemas.miniencuesta.model.dao.MeEncuestaAlternativaDao;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaAlternativa;
import pe.jaav.sistemas.miniencuesta.utiles.UtilesCommons;
 
@Repository
public class MeEncuestaAlternativaDaoImpl extends AbstractDaoImpl<MeEncuestaAlternativa, Integer> implements MeEncuestaAlternativaDao {
	protected  MeEncuestaAlternativaDaoImpl() {
		super(MeEncuestaAlternativa.class);
	}
 
	public int guardar(MeEncuestaAlternativa objDao) {
		Object result = getCurrentSession().save(objDao);
		return (int) (result!=null?result:0);
	}
 
 
	public int contarListado(MeEncuestaAlternativa objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
 
	@SuppressWarnings("unchecked")
	public List<MeEncuestaAlternativa> listar(MeEncuestaAlternativa objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);
		}
		return criteria.list();
	}
 
	public Criteria getCriteriaFilter(Object objDaoGen){
		Criteria criteria = null;
		if(objDaoGen instanceof MeEncuestaAlternativa){
			MeEncuestaAlternativa objDao = (MeEncuestaAlternativa)objDaoGen;
			criteria = getCurrentSession().createCriteria(MeEncuestaAlternativa.class);
			if (UtilesCommons.noEsVacio(objDao.getEnteCodigo())) {
				criteria.add(Restrictions.eq("enteCodigo", objDao.getEnteCodigo()));
			}
		}
		return criteria;
	}
}
