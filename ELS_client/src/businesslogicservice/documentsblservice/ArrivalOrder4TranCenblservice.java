package businesslogicservice.documentsblservice;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo.documentsVO.ArrivalOrder4TranCenVO;
import vo.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与中转中心到达单相关的业务逻辑
 *
 */
public interface ArrivalOrder4TranCenblservice {
	/**
	 * 前置：中转单ID在持久化数据中有记录
	 * 后置：自动得出出发地
	 * @param id
	 * @return 出发地
	 */

	public String generateStartAddress(String transderOrderId);
	
	/**
	 * 前置：已打开中转中心到达单输入页面
	 * 判断中转单是否存在
	 * @param id
	 * @return 是否存在
	 */
	public TransferOrderlineitemVO addTransferOrder(String id);
	
	/**
	 * 前置：已打开中转中心到达单输入页面
	 * 后置：自动生成中转中心到达单日期
	 * @return 日期
	 */
	public String generateDate();
	
	/**
	 * 前置：中转中心业务员已输入所有参数
	 * 后置：增加一个中转中心到达单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
 	 * @param gs
	 * @param tcid
	 * @return 一个中转中心到达单
	 */
	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO);
	
	/**
+	 * 前置：已添加所有中转中心到达单信息
+	 * 后置：自动生成中转中心到达单编号
	 * @return 中转中心到达单
	 */
	public String generateId();
	
	/**
+	 * 前置：要修改的中转中心到达单在持久化数据中有记录
+	 * 后置：更改一个中转中心到达单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
 	 * @param gs
	 * @param tcid
	 * @return 更改后的中转中心到达单
	 */
	public ResultMessage modify(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO);
	
	/**
	 * 前置：要删除的中转中心到达单在持久化数据中有记录
	 * 后置：删除一个中转中心到达单
	 * @param id
	 * @return 
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的中转中心到达单在持久化数据中有记录
	 * 后置：删除多个中转中心到达单
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的中转中心到达单在持久化数据中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单VO信息
	 * @param id
	 * @return 中转中心到达单信息
	 */
	public ArrayList<ArrivalOrder4TranCenVO> inquireA(String id);
	
	/**
	 * 前置：要查询的中转中心到达单在持久化数据中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单VO信息
	 * @param time
	 * @return 中转中心到达单列表
	 */
	public ArrayList<ArrivalOrder4TranCenVO> inquireB(String time);
	
	public ArrayList<ArrivalOrder4TranCenVO> inquireC();
	
	public void VOtoPO();
	
	public void POtoVO(int k);
	
	/**
	 * 前置：业务已经处理完成
	 * 后置：结束此次中转接收回合，持久化更新设计的领域对象的数据
	 */
	public void end();
}
