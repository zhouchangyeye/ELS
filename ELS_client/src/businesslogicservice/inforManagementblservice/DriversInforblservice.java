package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.DriversVO;

public interface DriversInforblservice {
	/**
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的司机信息
	 * @param vo
	 * @return
	 */
	public JavaBean1 add(DriversVO driversVO);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要查询的司机信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public JavaBean1 inquireA(String ID);
	
	public JavaBean1 inquireB(String busiHallID);

	/**
	 * 
	 * @param Ids
	 * 前置条件：要删除的司机信息在持久化数据中有记录
	 * 后置条件：删除多条司机信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	/**
	 * 
	 * @param vo
	 * @return
	 * 前置条件：要修改的司机信息在PO中有记录
	 * 后置条件：修改司机信息，并更新VO和PO
	 */
	public ResultMessage modify(DriversVO driversVO);

}
