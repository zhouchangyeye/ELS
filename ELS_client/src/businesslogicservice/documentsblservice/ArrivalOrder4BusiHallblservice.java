package businesslogicservice.documentsblservice;

import java.util.ArrayList;
 




import po.lineitemPO.documentslineitemPO.ArrivalOrder4BusiHalllineitemPO;
import state.GoodState;
import state.ResultMessage;
import vo.documentsVO.ArrivalOrder4BusiHallVO;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import vo.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
 
 /**
  * 
  * @author �쿡��
  * ������Ӫҵ�����ﵥ��ص�ҵ���߼�
  *
  */
 public interface ArrivalOrder4BusiHallblservice {
 	/**
 	 * ǰ�ã���ת��ID�ڳ־û��������м�¼
 	 * ���ã��Զ��ó�������
 	 * @param id
 	 * @return ������
 	 */
 	public String generateStartAddress(String id);
 	
 	/**
 	 * ǰ�ã�Ҫ���ӵ���ת�������ݳ־û��������м�¼
 	 * ���ã�������ת��lineitem��¼,����չʾ�㷵��VO
 	 * @param id
 	 * @return 
 	 */
 	public TransferOrderlineitemVO addTransferOrder(String id);
 	
 	/**
 	 * ǰ�ã�����������Ӧ���ֶ�����Ĳ���
 	 * ���ã��Զ�����Ӫҵ�����ﵥ����
 	 * @return ����
 	 */
 	public String generateDate();
 	
 	/**
 	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
 	 * ���ã�����һ��Ӫҵ�����ﵥ������VO��PO������VO��Ϣ��չʾ��
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return һ��Ӫҵ�����ﵥ
 	 */
 	public ResultMessage addArrivalOrder4BusiHall(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO);
 	
 	/**
 	 * ǰ�ã�����������Ӫҵ�����ﵥ��Ϣ
 	 * ���ã��Զ�����Ӫҵ�����ﵥ���
 	 * @return Ӫҵ�����ﵥ���
 	 */
 	public String generateId();
 	
 	/**
 	 * ǰ�ã�Ҫ�޸ĵ�Ӫҵ�����ﵥ�ڳ־û��������м�¼
 	 * ���ã�����һ��Ӫҵ�����ﵥ������VO��PO������VO��Ϣ��չʾ��
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return ���ĺ��Ӫҵ�����ﵥ
 	 */
 	public ResultMessage modify(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO);
 	
 	/**
 	 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
-	 * ���ã�ɾ��һ��Ӫҵ�����ﵥ
 	 * @param id
 	 */
 	public ResultMessage deleteone(String id);
 	
 	/**
 	 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
-	 * ���ã�ɾ�����Ӫҵ�����ﵥ
 	 * @param id
 	 */
 	public ResultMessage deleteMany(ArrayList<String> idlist);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ�ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥVO��Ϣ
 	 * @param id
 	 * @return Ӫҵ�����ﵥ��Ϣ
 	 */
 	public ArrayList<ArrivalOrder4BusiHallVO> inquireA(String id);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ�ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥVO��Ϣ
 	 * @param time
 	 * @return Ӫҵ�����ﵥ�б�
 	 */
 	public ArrayList<ArrivalOrder4BusiHallVO> inquireB(String time);
 	
 	/**
 	 * ǰ�ã�ҵ���Ѿ��������
 	 * ���ã������˴�Ӫҵ�����ջغϣ��־û�������Ƶ�������������
 	 */
 	
 	/**
 	 * ǰ�ã�
 	 * ���ã���ѯ������Ӫҵ�����ﵥ
 	 * @return
 	 */
 	public ArrayList<ArrivalOrder4BusiHallVO> inquireC();
 	
 	public void VOtoPO();
		
 	public void POtoVO(int k);
 	
 	public void end();
}