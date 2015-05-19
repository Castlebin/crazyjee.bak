package ch10.hrsystem.dao;

import java.util.List;

import ch10.common.dao.BaseDao;
import ch10.hrsystem.domain.Employee;
import ch10.hrsystem.domain.Payment;

public interface PaymentDao extends BaseDao<Payment> {

	List<Payment> findByEmp(Employee emp);
	
	Payment findByEmpAndMonth(Employee emp, String payMonth);
	
}
