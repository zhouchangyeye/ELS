package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo_client.userVO.CourierVO;
import businesslogicservice_client.documentsblservice.DeliveryOrderblservice;
/**
 * �ɼ���
 * @author �쿡��
 *׮
 */
public class DeliveryOrder implements DeliveryOrderblservice{

	@Override
	public CourierVO getDeliverier(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDeliverier(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> addOrder(String orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderVO addDeliveryOrder(String id,
			ArrayList<String> orsderidlist, String dn, String did, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderVO modify(String id, ArrayList<String> orsderidlist,
			String dn, String did, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteone(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(ArrayList<String> id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DeliveryOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
}
