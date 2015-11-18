package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;
 

 import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
 
 /**
  * 
  * @author 朱俊文
  * 处理与营业厅到达单相关的业务逻辑
  *
  */
 public interface ArrivalOrder4BusiHallblservice {
 	/**
 	 * 前置：中转单ID在持久化数据中有记录
 	 * 后置：自动得出出发地
 	 * @param id
 	 * @return 出发地
 	 */
 	public String generateStartAddress(String id);
 	
 	/**
 	 * 前置：要添加的中转单在数据持久化对象中有记录
 	 * 后置：添加中转单lineitem记录,并向展示层返回VO
 	 * @param id
 	 * @return 
 	 */
 	public TransferOrderlineitemVO addTransferOrder(String id);
 	
 	/**
 	 * 前置：已输入所有应该手动输入的参数
 	 * 后置：自动生成营业厅到达单日期
 	 * @return 日期
 	 */
 	public String generateDate();
 	
 	/**
 	 * 前置：营业厅业务员已输入所有参数
 	 * 后置：增加一个营业厅到达单，更新VO，PO，返回VO信息到展示层
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return 一个营业厅到达单
 	 */
 	public ArrivalOrder4BusiHallVO addArrivalOrder4BusiHall(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO);
 	
 	/**
 	 * 前置：已添加所有营业厅到达单信息
 	 * 后置：自动生成营业厅到达单编号
 	 * @return 营业厅到达单编号
 	 */
 	public String generateId();
 	
 	/**
 	 * 前置：要修改的营业厅到达单在持久化数据中有记录
 	 * 后置：更改一个营业厅到达单，更新VO，PO，返回VO信息到展示层
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return 更改后的营业厅到达单
 	 */
 	public ArrivalOrder4BusiHallVO modify(String id,String toid,String sa,String d,GoodState gs);
 	
 	/**
 	 * 前置：要删除的营业厅到达单在持久化数据中有记录
-	 * 后置：删除一个营业厅到达单
 	 * @param id
 	 */
 	public ResultMessage deleteone(String id);
 	
 	/**
 	 * 前置：要删除的营业厅到达单在持久化数据中有记录
-	 * 后置：删除多个营业厅到达单
 	 * @param id
 	 */
 	public ResultMessage deleteMany(ArrayList<String> idlist);
 	
 	/**
 	 * 前置：要查询的营业厅到达单在持久化数据中有记录
 	 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单VO信息
 	 * @param id
 	 * @return 营业厅到达单信息
 	 */
 	public ArrivalOrder4BusiHallVO inquireA(String id);
 	
 	/**
 	 * 前置：要查询的营业厅到达单在持久化数据中有记录
 	 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单VO信息
 	 * @param time
 	 * @return 营业厅到达单列表
 	 */
 	public ArrivalOrder4BusiHalllineitemVO inquireB(String time);
 	
 	/**
 	 * 前置：业务已经处理完成
 	 * 后置：结束此次营业厅接收回合，持久化更新设计的领域对象的数据
 	 */
 	public void end();
}
