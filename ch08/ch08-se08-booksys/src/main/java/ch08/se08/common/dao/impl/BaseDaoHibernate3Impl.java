package ch08.se08.common.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ch08.se08.common.dao.BaseDao;

public class BaseDaoHibernate3Impl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return getHibernateTemplate().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		return getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		delete(get(entityClazz, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return (List<T>)getHibernateTemplate()
				.find("select en from " + entityClazz.getSimpleName() + " en");
	}

	@SuppressWarnings("unchecked")
	@Override
	public long findCount(Class<T> entityClazz) {
		List<T> l = (List<T>)getHibernateTemplate()
				.find("select count(*) from " + entityClazz.getSimpleName());
		return (Long)l.get(0);
	}
	
	
	/**
	 * 使用HQL进行分页查询
	 * @param hql 需要进行查询的HQL查询语句
	 * @param pageNo　第几页
	 * @param pageSize 每页多少条记录
	 * @return 当前页的所有结果
	 */
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		// 通过一个HibernateCallback对象来执行查询
		List<T> list = (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				@SuppressWarnings("unchecked")
				List<T> result = session.createQuery(hql)
						.setFirstResult((pageNo - 1) * pageSize)
						.setMaxResults(pageSize)
						.list();
				return result;
			}
		});
		
		return list;
	}
	
	/**
	 * 使用HQL进行分页查询
	 * @param hql 需要进行查询的HQL查询语句
	 * @param pageNo　第几页
	 * @param pageSize 每页多少条记录
	 * @return 当前页的所有结果
	 */
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		// 通过一个HibernateCallback对象来执行查询
		List<T> list = (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				for(int i=0; i<params.length; i++) {
					query.setParameter(i+"", params[i]);
				}
				@SuppressWarnings("unchecked")
				List<T> result = query.setFirstResult((pageNo - 1) * pageSize)
						.setMaxResults(pageSize)
						.list();
				return result;
			}
		});
		
		return list;
	}

}
