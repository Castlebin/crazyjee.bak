package ch08.se02.dao.impl;

import ch08.se02.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Override
	public void save(T e) {
		System.out.println("程序保存类型为：" + e.getClass() + "的变量：" + e);
	}
	
}
