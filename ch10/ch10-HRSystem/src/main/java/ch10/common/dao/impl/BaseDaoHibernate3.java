package ch10.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import ch10.common.dao.BaseDao;

public class BaseDaoHibernate3<T> extends HibernateDaoSupport implements BaseDao<T> {

	// 根据ID加载实体
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
		getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		getHibernateTemplate().delete(get(entityClazz, id));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entityClazz) {
		return (List<T>)getHibernateTemplate().find("select en from " + entityClazz.getSimpleName() + " en");
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		return (Long)getHibernateTemplate().find("select count(*) from " + entityClazz.getSimpleName()).get(0);
	}
	
	// 分页查询
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		// 通过一个HibernateCallback对象来执行查询
		List<T> list = (List<T>)getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				for(int i=0; i<params.length; i++) {
					query.setParameter(i, params[i]);
				}
				List<T> result = query.setFirstResult((pageNo - 1) * pageSize)
						.setMaxResults(pageSize)
						.list();
				return result;
			}
		});
		
		return list;
	}

}
