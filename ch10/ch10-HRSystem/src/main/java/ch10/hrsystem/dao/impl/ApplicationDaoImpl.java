package ch10.hrsystem.dao.impl;

import java.util.List;

import ch10.common.dao.impl.BaseDaoHibernate4;
import ch10.hrsystem.dao.ApplicationDao;
import ch10.hrsystem.domain.Application;
import ch10.hrsystem.domain.Employee;

public class ApplicationDaoImpl extends BaseDaoHibernate4<Application> implements ApplicationDao {

	@Override
	public List<Application> findByEmp(Employee emp) {
		return find("select a from Application a "
				+ "where a.attend.employee=?0" + emp);
	}

}
