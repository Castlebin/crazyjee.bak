package ch10.hrsystem.dao;

import java.util.List;

import ch10.common.dao.BaseDao;
import ch10.hrsystem.domain.Attend;
import ch10.hrsystem.domain.AttendType;
import ch10.hrsystem.domain.Employee;

public interface AttendDao extends BaseDao<Attend> {

	/**
	 * 根据员工、月份 查询该员工的打卡记录
	 * @param month 月份，月份是形如2012-02格式的字符串
	 */
	List<Attend> findByEmpAndMouth(Employee emp, String mouth);
	
	/**
	 * 根据员工、日期 查询该员工的打卡记录合集
	 * @return 该员工某一天的打卡记录
	 */
	List<Attend> findByEmpAndDutyDay(Employee emp, String dutyDay);
	
	/**
	 * 查询员工某一天特定的打卡记录（来了、还是没来）
	 * 
	 */
	List<Attend> findByEmpAndDutyDayAndCome(Employee emp, String dutyDay, boolean isCome);
	
	List<Attend> findByEmpUnAttend(Employee emp, AttendType type);
}
