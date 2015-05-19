package ch10.hrsystem.dao;

import java.util.List;

import ch10.common.dao.BaseDao;
import ch10.hrsystem.domain.Application;
import ch10.hrsystem.domain.Employee;

public interface ApplicationDao extends BaseDao<Application> {

	// 根据员工来查询他对应的未被处理的申请
	List<Application> findByEmp(Employee emp);
	
}
