package businesslogicservice.stockblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.stockVO.OutBoundOrderVO;
/**
 * 
 * @author 周畅
 * 该接口处理与出库单相关的业务逻辑
 *
 */
public interface OutBoundOrderblservice {
	
	/**
	 * 
	 * @param id
	 * 前置条件：启动一个新建或修改出库单回合
	 * 后置条件：在出库单中增加一个快件编号，返回展示层快件的部分信息（LineItem形式）
	 * 
	 */
	public OrderlineitemVO addExpress(String expressID);
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * 前置条件：库存管理人员已经输入了所有出库单参数值
	 * 后置条件:增加一个出库单，更新变动到VO和PO，把VO信息返回到展示层
	 */
	public JavaBean1 add(OutBoundOrderVO outBoundOrderVO);
	
	/**
	 * 
	 * @param id4obo
	 * 前置条件：要删除的出库单在持久化数据中有记录
	 * 后置条件：删除多个出库单
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * 前置条件：要修改的出库单在持久化数据中有记录
	 * 后置条件：修改一个出库单，更新相关信息到VO和PO，把VO信息返回到展示层
	 */
	public JavaBean1 modify(OutBoundOrderVO outBoundOrderVO);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：要查询的出库单在持久化数据中有记录
	 * 后置条件：根据id查询某出库单,返回出库单VO信息
	 */
	public JavaBean1 inquireA(String ID);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：库存管理人员已经被授权和登录
	 * 后置条件：根据时间查询某出库单,返回出库单VO信息
	 */
	public JavaBean1 inquireB(String date);

}
