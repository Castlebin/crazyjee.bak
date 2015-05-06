package ch08.se02.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ch08.se02.dao.BaseDao;
import ch08.se02.service.BaseService;

public class BaseServieImpl<T> implements BaseService<T> {
	
	@Autowired
	private BaseDao<T> dao;

	@Override
	public void addEntity(T e) {
		System.out.println("调用" + dao + "保存实体： " + e);
	}

}
