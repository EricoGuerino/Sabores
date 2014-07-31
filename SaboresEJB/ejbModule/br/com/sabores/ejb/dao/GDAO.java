package br.com.sabores.ejb.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("serial")
public class GDAO<T> implements Serializable
{
	private static final String UNIT_NAME = "SaboresPU";
	
	@PersistenceContext(unitName = UNIT_NAME)
	private EntityManager em;
	
	@SuppressWarnings("rawtypes")
	private Class entityClass;
	
	@SuppressWarnings("rawtypes")
	public Class getEntityClass()
	{
		return entityClass;
	}
	
	@SuppressWarnings("rawtypes")
	public void setEntityClass(Class entityClass)
	{
		if (entityClass == null) {
            //only works if one extends BaseDao, we will take care of it with CDI
            entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}
	
	@Produces
	public EntityManager getEm()
	{
		return this.em;
	}
	
	public GDAO(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	public void inserir(T t)
	{
		em.persist(t);
	}
	
	public T alterar(T t)
	{
		T t2 = em.merge(t);
		return t2;
	}
	
	@SuppressWarnings("unchecked")
	public T findOne(Long id)
	{
		return (T) em.find(this.entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public void apagar(Long id)
	{
		T removableEntity = (T) em.find(this.entityClass, id);
		em.remove(removableEntity);
	}
	
	
}