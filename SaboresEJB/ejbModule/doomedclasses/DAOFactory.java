package doomedclasses;
//package br.com.sabores.ejb.dao;
//
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//
//import javax.enterprise.context.Dependent;
//import javax.enterprise.context.spi.CreationalContext;
//import javax.enterprise.inject.Produces;
//import javax.enterprise.inject.spi.Bean;
//import javax.enterprise.inject.spi.BeanManager;
//import javax.enterprise.inject.spi.InjectionPoint;
//
//import br.com.sabores.ejb.annotations.Dao;
//
//public class DAOFactory implements Serializable
//{
//	
//	@Dependent
//	@Produces
//	  public GDAO create(InjectionPoint injectionPoint) {
//	    ParameterizedType type = (ParameterizedType) injectionPoint.getType();
//	    Class<?> classe = (Class<?>) type.getActualTypeArguments()[0];
//	    return new GDAO(classe);
//	  }
////	private static final long serialVersionUID = 1L;
////
////	@SuppressWarnings("unchecked")
////	@Produces
////	@Dependent
////	@Dao
////	public GDAO<T> produce(InjectionPoint ip, BeanManager bm)
////	{
////		if (ip.getAnnotated().isAnnotationPresent(Dao.class)) {
////			GDAO<T> genericDao = (GDAO<T>) this.getBeanByName("GDAO", bm);// ask bean manager for a instance of GenericDao
////			ParameterizedType type = (ParameterizedType) ip.getType();
////			Type[] typeArgs = type.getActualTypeArguments();
////			Class<T> entityClass = (Class<T>) typeArgs[0];
////			genericDao.setEntityClass(entityClass);
////			return genericDao;
////		}
////		throw new IllegalArgumentException("Annotation @Dao é obrigatória ao injetar GDAO");
////	}
////
////	@SuppressWarnings({ "rawtypes", "unchecked" })
////	public Object getBeanByName(String name, BeanManager bm)
////	{
////		Bean bean = bm.getBeans(name).iterator().next();
////		CreationalContext ctx = bm.createCreationalContext(bean); 
////		Object o = bm.getReference(bean, bean.getBeanClass(), ctx); 
////		return o;
////	}
//
//}
