package ch10.hrsystem.dao;

import java.util.List;

import ch10.common.dao.BaseDao;
import ch10.hrsystem.domain.Employee;

public interface EmployeeDao extends BaseDao<Employee> {

	// emp 必须包含name、pass
	List<Employee> findByNameAndPass(Employee emp);
	
	Employee findByName(String name);
}
