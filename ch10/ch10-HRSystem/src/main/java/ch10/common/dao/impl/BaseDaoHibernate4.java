package ch10.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import ch10.common.dao.BaseDao;

public class BaseDaoHibernate4<T> implements BaseDao<T> {
	// DAO组件进行持久化操作底层所依赖的SessionFactory组件
	private SessionFactory sessionFactory;

	// 依赖注入SessionFactory所需要的setter方法
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 根据ID加载实体
	@Override
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		getSessionFactory().getCurrentSession().createQuery("delete " + entityClazz.getSimpleName()
				+ " en where en.id=?0")
				.setParameter("0", id)
				.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 设值
		for(int i=0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		
		return (List<T>)query.list();
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		return (Long)find("select count(*) from " + entityClazz.getSimpleName()).get(0);
	}
	
	// 分页查询
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i=0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		
		return (List<T>)query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}

}
