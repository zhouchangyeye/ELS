package businesslogic.documentsbl;

import java.util.ArrayList;
import state.ResultMessage;
import vo.documentsVO.ReceivablesOrderVO;
import bean.JavaBean1;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
/**
 * 
 * @author �ܳ�
 *
 */
public class ReceivablesOrder implements ReceivablesOrderblservice{

	@Override
	public ReceivablesOrderVO add(String date4ro, String amount4ro,
			String courier4ro, ArrayList<String> barCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String date, String courierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4courier,
			ArrayList<String> date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceivablesOrderVO modify(String id4courier, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void countCarriage(String depature, String destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void countAmount(ArrayList<String> OrderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
