package ch08.se02.dao;

public interface BaseDao<T> {
	
	void save(T e);
	
}
