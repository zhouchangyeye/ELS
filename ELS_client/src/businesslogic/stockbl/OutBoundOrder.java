package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.stockPO.OutBoundOrderPO;
import dataservice.stockdataservice.OutBoundOrderdataservice;
import state.ApproState;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.stockVO.OutBoundOrderVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
import businesslogicservice.stockblservice.OutBoundOrderblservice;
/**
 * 
 * @author 周畅
 *
 */
public class OutBoundOrder implements OutBoundOrderblservice {
	private OutBoundOrderdataservice outBoundOrderdataservice;
	private OutBoundOrderVO outBoundOrderVO;
	private OutBoundOrderPO outBoundOrderPO;
	private ArrayList<OutBoundOrderPO> arrayList;
	private ArrayList<OutBoundOrderVO> arrayList2;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private Stock stock;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	private String date;
	
	public OutBoundOrder() {
		try {
			outBoundOrderdataservice = RMIHelper.getOutBoundOrderdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OrderlineitemVO addExpress(String expressID) {
		order = new Order();
		orderlineitemVO = order.getOrderlineitemVO(expressID);
		
		return orderlineitemVO;
	}

	public String generateId() {
		String id = null;
//		id = "" + outBoundOrderdataservice.gene
		//这里调用数据层的生成id方法
		return id;
	}

	public String generateTime() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public JavaBean1 add(OutBoundOrderVO outBoundOrderVO) {
		outBoundOrderPO = new OutBoundOrderPO();
		this.outBoundOrderVO = outBoundOrderVO;
		
		this.outBoundOrderVO.setOutDate(generateTime());
		this.outBoundOrderVO.setId(generateId());
		this.outBoundOrderVO.setApproState(ApproState.NotApprove);
		VOtoPO();
		
		try {
			resultMessage = outBoundOrderdataservice.add(outBoundOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.outBoundOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteone(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		try {
			resultMessage = outBoundOrderdataservice.deleteMany(IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(OutBoundOrderVO outBoundOrderVO) {
		outBoundOrderPO = new OutBoundOrderPO();
		this.outBoundOrderVO = outBoundOrderVO;
		
		VOtoPO();
		try {
			resultMessage = outBoundOrderdataservice.update(outBoundOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String ID) {
		try {
			javaBean1 = outBoundOrderdataservice.findA(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<OutBoundOrderPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = outBoundOrderdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<OutBoundOrderPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
			
		return javaBean1;
	}

	public void VOtoPO() {
		outBoundOrderPO.setId(outBoundOrderVO.getId());
		outBoundOrderPO.setOutDate(outBoundOrderVO.getOutDate());
		outBoundOrderPO.setApproState(outBoundOrderVO.getApproState());
		outBoundOrderPO.setDestination(outBoundOrderVO.getDestination());
		outBoundOrderPO.setGenerateTime(outBoundOrderVO.getGenerateTime());
		outBoundOrderPO.setOrderID(outBoundOrderVO.getOrderID());
		outBoundOrderPO.setTransportType(outBoundOrderVO.getTransportType());
		outBoundOrderPO.setTruckNum(outBoundOrderVO.getTruckNum());
	}
	
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<>();
		
		for (int i = 0; i < k; i++) {
			outBoundOrderPO = arrayList.get(i);
			
			outBoundOrderVO = new OutBoundOrderVO();
			outBoundOrderVO.setId(outBoundOrderPO.getId());
			outBoundOrderVO.setOutDate(outBoundOrderPO.getOutDate());
			outBoundOrderVO.setApproState(outBoundOrderPO.getApproState());
			outBoundOrderVO.setOrderID(outBoundOrderPO.getOrderID());
			outBoundOrderVO.setTransportType(outBoundOrderPO.getTransportType());
			outBoundOrderVO.setTruckNum(outBoundOrderPO.getTruckNum());
			outBoundOrderVO.setDestination(outBoundOrderPO.getDestination());
			
			arrayList2.add(outBoundOrderVO);
		}
	}
	
}
