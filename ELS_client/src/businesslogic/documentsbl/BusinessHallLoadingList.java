package businesslogic.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.BusinessHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusinessHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogic.utilitybl.JavaBean;
import businesslogicservice.documentsblservice.BusinessHallLoadingListblservice;
/**
 * 
 * @author 朱俊文
 *
 */
public class BusinessHallLoadingList implements BusinessHallLoadingListblservice{

	@Override
	public ResultMessage addBusiHall(String businessHallId) {
		
		return null;
	}

	@Override
	public OrderlineitemVO addOrder(String orderid) {
		return null;
	}

	@Override
	public String generateDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTruckId(String bhid, String d) {
		//调用数据层方法,自动生成 营业厅编号+20150921日期+00000编码 、五位数字
		return null;
	}

	@Override
	public double generateFreight(String sa, String ea) {

		
		return 0;
	}

	@Override
	public JavaBean addBusinessHallLoadingList(BusinessHallLoadingListVO businessHallLoadingListVO) {

		
		return null;
	}

	@Override
	public String generateId() {
		//调用数据层方法
		
		return null;
	}

	@Override
	public ResultMessage modify(BusinessHallLoadingListVO businessHallLoadingListVO) {

		
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		return null;
	}

	@Override
	public BusinessHallLoadingListVO inquireA(String id) {
		return null;
	}

	@Override
	public BusinessHallLoadingListlineitemVO inquireB(String time) {
		return null;
	}

	@Override
	public void end() {
		
	}

	@Override
	public void VOtoPO() {
		
	}

	

}
