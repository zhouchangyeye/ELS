package businesslogic.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import state.TransportType;
import vo.documentsVO.TransferOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogicservice.documentsblservice.TransferOrderblservice;
/**
 * 
 * @author �쿡��
 * 
 */
public class TransferOrder implements TransferOrderblservice {

	@Override
	public OrderlineitemVO addOrder(String orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int generateFare(String sa, String ea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage addTransferOrder(TransferOrderVO transferOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(TransferOrderVO transferOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransferOrderlineitemVO getTransferOrderlineitemVO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}