package pe.jaav.sistemas.miniencuesta.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import pe.jaav.sistemas.miniencuesta.model.dao.AbstractDao;
import pe.jaav.sistemas.miniencuesta.model.domain.EntidadSup;
import pe.jaav.sistemas.miniencuesta.utiles.UtilesCommons;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
//import java.util.Optional;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;



public abstract class AbstractDaoImpl<E, I extends Serializable>  implements AbstractDao<E,I> {

	  public static final String ORDER_ASC  = "ASC";
	    public static final String ORDER_DESC = "DESC";

	    private Class<E> entityClass;

	    protected AbstractDaoImpl(Class<E> entityClass) {
	        this.entityClass = entityClass;
	    }

	    @Autowired
	    private SessionFactory sessionFactory;

	    public Session getCurrentSession() {
	    	Session sf = sessionFactory.getCurrentSession();
	        return sf;
	    }

	    //@SuppressWarnings("unchecked")
	    //@Override
	    public E findById(I id) {
	        return (E) getCurrentSession().get(entityClass, id);
	    }
	    
	    @Override
	    public void saveOrUpdate(E e) {
	        getCurrentSession().saveOrUpdate(e);	        
	    }
	    
	    @Override
	    public void update(E e) {    	
	        getCurrentSession().update(e);	        
	    }

	    @Override
	    public void save(E e) {    	
	        getCurrentSession().save(e);	        
	    }

	    
	    @Override
	    public void delete(E e) {
	        getCurrentSession().delete(e);	        
	    }

	    public List<E> findByCriteria(Criterion criterion) {
	    	return null;
	    }
	    
//	    @SuppressWarnings("unchecked")
//	    public List<E> findByCriteria(Criterion criterion) {
//	        Criteria criteria = getCurrentSession().getCriteriaBuilder().createQuery(entityClass);	        
//	        criteria.add(criterion);
//	        return criteria.list();
//	    }
	    
	    
	    public void setPaginable(EntidadSup entidad, Criteria criteria){        
	        criteria.setFirstResult(entidad.getInicio());
	        criteria.setMaxResults(entidad.getNumeroFilas());
	        criteria.setFetchSize(entidad.getNumeroFilas());        
	    }
	    
	    
	    public void setOrdenableAtrib(Criteria criteria, String order, String ... columns){
	        if(columns != null && columns.length > 0){
	            List<String> list = Arrays.asList(columns);
	            for(String column : list){
	                if(order.equalsIgnoreCase(ORDER_ASC)){
	                    criteria.addOrder(Order.asc(column));
	                }else{
	                    criteria.addOrder(Order.desc(column));
	                }
	            }
	        }
	    }
	    
	    public void setOrdenable(Criteria criteria, String order, List<String> list){
	        if(UtilesCommons.noEsVacio(list)){
	            for(String column : list){
	                if(order.equalsIgnoreCase(ORDER_ASC)){
	                    criteria.addOrder(Order.asc(column));
	                }else{
	                    criteria.addOrder(Order.desc(column));
	                }
	            }
	        }
	    }
	    
		        
	    
}