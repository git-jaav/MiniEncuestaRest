package pe.jaav.sistemas.miniencuesta.model.dao.impl;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pe.jaav.sistemas.miniencuesta.model.dao.MeEncuestaTemaDao;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaTema;
import pe.jaav.sistemas.miniencuesta.utiles.UtilesCommons;
 
@Repository
public class MeEncuestaTemaDaoImpl extends AbstractDaoImpl<MeEncuestaTema, String> implements MeEncuestaTemaDao {
	
	protected  MeEncuestaTemaDaoImpl() {
		super(MeEncuestaTema.class);
	}
  
	public int contarListado(MeEncuestaTema objDao) {
		Criteria criteria = getCriteriaFilter(objDao);
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
 
	@SuppressWarnings("unchecked")
	public List<MeEncuestaTema> listar(MeEncuestaTema objDao,boolean paginable) {
		Criteria criteria = getCriteriaFilter(objDao);
		if(paginable){
			setPaginable(objDao, criteria);
		}
		return criteria.list();
	}
 
	public Criteria getCriteriaFilter(Object objDaoGen){
		Criteria criteria = null;
		if(objDaoGen instanceof MeEncuestaTema){
			MeEncuestaTema objDao = (MeEncuestaTema)objDaoGen;
			criteria = getCurrentSession().createCriteria(MeEncuestaTema.class);
			if (UtilesCommons.noEsVacio(objDao.getEnteEstado())) {
				criteria.add(Restrictions.eq("rolCodigo", objDao.getEnteEstado()));
			}
		}
		return criteria;
	}

}
