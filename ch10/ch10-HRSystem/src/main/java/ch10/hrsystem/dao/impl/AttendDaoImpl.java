package ch10.hrsystem.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import ch10.common.dao.impl.BaseDaoHibernate4;
import ch10.hrsystem.dao.AttendDao;
import ch10.hrsystem.domain.Attend;
import ch10.hrsystem.domain.AttendType;
import ch10.hrsystem.domain.Employee;

public class AttendDaoImpl extends BaseDaoHibernate4<Attend> implements
		AttendDao {

	@Override
	public List<Attend> findByEmpAndMonth(Employee emp, String month) {
		return find("select a from Attend where a.employee=?0 "
				+ "and substring(a.dutyDay, 0, 7)=?1", emp, month);
	}

	@Override
	public List<Attend> findByEmpAndDutyDay(Employee emp, String dutyDay) {
		return find("select a from Attend where a.employee=?0 "
				+ "and a.dutyDay =?1", emp, dutyDay);
	}

	@Override
	public List<Attend> findByEmpAndDutyDayAndCome(Employee emp,
			String dutyDay, boolean isCome) {
		return find("select a from Attend where a.employee=?0 "
				+ "and a.dutyDay =?1 "
				+ "and a.isCome", emp, dutyDay, isCome);
	}

	// 查看员工前三天的非正常打卡
	@Override
	public List<Attend> findByEmpUnAttend(Employee emp, AttendType type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -3);
		String start = sdf.format(c.getTime());
		
		return find("select a from Attend where a.employee=?0 "
				+ "and a.type!=?1 "
				+ "and a.dutyDay > ?2", emp, type, start);
	}

}
