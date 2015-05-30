package ch08.se08.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import ch08.se08.common.dao.BaseDao;

public class BaseDaoHibernate4Impl<T> implements BaseDao<T> {
	private Class<T> entityClazz;
	
	// DAO组件需要的SessionFactory对象
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	// 设值注入需要的setter方法
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id) {
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
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
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName() +" en where en.id=?0")
				.setParameter("0", id)
				.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return (List<T>)getSessionFactory().getCurrentSession()
				.createQuery(hql)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		Query query = getSessionFactory().getCurrentSession()
				.createQuery(hql);
		// 设值
		for(int i=0; i<params.length; i++) {
			query.setParameter(i+"", params[i]);
		}
		
		return (List<T>)query.list();
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		List<T> l = find("select count(*) from " + entityClazz.getSimpleName());
		return (Long)l.get(0);
	}
	
	
	/**
	 * 使用HQL进行分页查询
	 * @param hql 需要进行查询的HQL查询语句
	 * @param pageNo　第几页
	 * @param pageSize 每页多少条记录
	 * @return 当前页的所有结果
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		return (List<T>)getSessionFactory().getCurrentSession()
				.createQuery(hql)
				.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize)
				.list();		
	}
	
	/**
	 * 使用HQL进行分页查询
	 * @param hql 需要进行查询的HQL查询语句
	 * @param pageNo　第几页
	 * @param pageSize 每页多少条记录
	 * @return 当前页的所有结果
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = getSessionFactory().getCurrentSession()
				.createQuery(hql);
		for(int i=0; i<params.length; i++) {
			query.setParameter(i+"", params[i]);
		}
		
		return (List<T>)query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}

}
