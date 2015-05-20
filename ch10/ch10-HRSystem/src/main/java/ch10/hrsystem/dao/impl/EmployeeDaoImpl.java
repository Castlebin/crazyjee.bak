package ch10.hrsystem.dao.impl;

import java.util.List;

import ch10.common.dao.impl.BaseDaoHibernate4;
import ch10.hrsystem.dao.EmployeeDao;
import ch10.hrsystem.domain.Employee;

public class EmployeeDaoImpl extends BaseDaoHibernate4<Employee> implements EmployeeDao {

	@Override
	public List<Employee> findByNameAndPass(Employee emp) {
		return find("select e from Employee e where e.name=?0 and e.pass=?1", emp.getName(), emp.getPass());
	}

	@Override
	public Employee findByName(String name) {
		List<Employee> list =  find("select e from Employee e where e.name=?0 ", name);
		if(list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

}
