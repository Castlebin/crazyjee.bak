package ch10.hrsystem.dao;

import java.util.List;

import ch10.common.dao.BaseDao;
import ch10.hrsystem.domain.Manager;

public interface ManagerDao extends BaseDao<Manager> {

	// emp 必须包含name、pass
	List<Manager> findByNameAndPass(Manager emp);
	
	Manager findByName(String name);
}
