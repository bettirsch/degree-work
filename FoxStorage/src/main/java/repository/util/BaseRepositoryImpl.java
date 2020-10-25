/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.BaseModel;

/**
 *
 * @author spdue4cb
 * @param <E> class
 * @param <I> id
 */
@Stateless
public class BaseRepositoryImpl<E extends BaseModel> implements BaseRepository<E> {

	private Class<E> entityClass;

	@Inject
	private EntityManagerProvider entityManagerProvider;

	@Override
	public void setRepository(Class<E> classE) {
    	this.entityClass = classE;
    }

	public EntityManager getEntityManager() {
		return this.entityManagerProvider.getEntityManager();
	}
	
	@Override
	public E create(E entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public E find(Integer entityId) {
		return getEntityManager().find(entityClass, entityId);
	}

	@Override
	public E find(BaseModel entity) {
		return getEntityManager().find(entityClass, entity);
	}

	@Override
	public E update(E entity) {
		entity.setModifiedTs(new Date());
		return getEntityManager().merge(entity);
	}

	@Override
	public List<E> findAll() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<E> root = criteriaQuery.from(entityClass);
		CriteriaQuery<E> all = criteriaQuery.select(root);
		TypedQuery<E> allQuery = getEntityManager().createQuery(all);
		return allQuery.getResultList();
	}
	
    @Override
    public List<E> createTypedQueryResultList(String namedQueryName, Map<String, String> queryParamMap) {
        TypedQuery<E> query = getEntityManager().createNamedQuery(namedQueryName, entityClass);
        for (Entry<String, String> entry : queryParamMap.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
        List<E> result = query.getResultList();
        if(result.isEmpty()){
            return new ArrayList<>();
        }else{
            return result;
        }
    }
    
    @Override
    public E createTypedQuerySingleResult(String namedQueryName, Map<String, String> queryParamMap) {
        List<E> result = createTypedQueryResultList(namedQueryName, queryParamMap);
        if(result.isEmpty()){
            return null;
        }else{
            return result.get(0);
        }
    }
}
