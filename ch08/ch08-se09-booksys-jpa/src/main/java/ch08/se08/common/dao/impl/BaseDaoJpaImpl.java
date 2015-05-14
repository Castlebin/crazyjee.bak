package ch08.se08.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch08.se08.common.dao.BaseDao;

public class BaseDaoJpaImpl<T> implements BaseDao<T> {
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return entityManager.find(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		entityManager.persist(entity);
		try {
			return (Serializable)entity.getClass().getMethod("getId").invoke(entity);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(entity + "必须提供getId()方法！");
		}
	}

	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		entityManager.createQuery("delete " + entityClazz.getSimpleName()+ " en where en.id=?0")
					.setParameter(0, id)
					.executeUpdate();
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql) {
		return (List<T>)entityManager.createQuery(jpql).getResultList();
	}
	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql, Object... params) {
		Query query = entityManager.createQuery(jpql);
		for(int i=0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return (List<T>)query.getResultList();
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		return (Long)l.get(0);
	}
	
	/**
	 * 使用JPQL语句进行分页查询
	 * @param jpql 使用的JPQL查询语句
	 * @param pageNo 第几页
	 * @param pageSize　每页显示的记录数量
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql, int pageNo, int pageSize) {
		return entityManager.createQuery(jpql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
	}
	
	/**
	 * 使用JPQL语句进行分页查询
	 * @param jpql 使用的JPQL查询语句
	 * @param pageNo 第几页
	 * @param pageSize　每页显示的记录数量
	 * @param params 设置参数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql, int pageNo, int pageSize, Object... params) {
		Query query = entityManager.createQuery(jpql);
		for(int i=0; i<params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
	}

}
