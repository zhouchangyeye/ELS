package businesslogic.managerAndAccountantbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import po.StatisAnalyPO.CostAndIncomePO;
import po.documentsPO.PaymentOrderPO;
import po.documentsPO.ReceivablesOrderPO;
import state.ResultMessage;
import vo.StatisAnalyVO.CostAndIncomeVO;
import dataservice.managerAndAccountantdataservice.StatisAnalydataservice;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.utilitybl.Time;
import businesslogicservice.managerAndAccountantblservice.StatisAnalyblservice;

public class StatisAnaly implements StatisAnalyblservice {
	private ParentDocumentsdataservice parentDocumentsdataservice;
	private ArrayList<ReceivablesOrderPO> receivablesOrderPOs;
	private ArrayList<PaymentOrderPO> paymentOrderPOs;
	private CostAndIncomePO costAndIncomePO;
	private CostAndIncomeVO costAndIncomeVO;
	private JavaBean1 javaBean1;
	private ResultMessage resultMessage;
	private ArrayList<String> arrayList;
	
	@Override
	public JavaBean1 inquireReceivalblesOrder(String ID) {
		try {
			parentDocumentsdataservice = RMIHelper.getReceivablesOrderdataservice();
			javaBean1 = parentDocumentsdataservice.findA(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquirePaymentOrder(String ID) {
		try {
			parentDocumentsdataservice = RMIHelper.getPaymentOrderdataservice();
			javaBean1 = parentDocumentsdataservice.findA(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireReceivalblesOrder2(String beginDate, String endDate) {
		try {
			arrayList = Time.getEveryDay(beginDate, endDate);
			parentDocumentsdataservice = RMIHelper.getReceivablesOrderdataservice();
		} catch (ParseException | RemoteException e) {
			e.printStackTrace();
		}
		
		int k = arrayList.size();
		String date;
		ArrayList<ReceivablesOrderPO> temp;
		receivablesOrderPOs = new ArrayList<ReceivablesOrderPO>();
		
		for (int i = 0; i < k; i++) {
			date = arrayList.get(i);
			
			try {
				javaBean1 = parentDocumentsdataservice.findB(date);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			temp = (ArrayList<ReceivablesOrderPO>)javaBean1.getObject();
			receivablesOrderPOs.addAll(temp);
		}
		
		javaBean1.setObject(receivablesOrderPOs);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquirePaymentOrder2(String beginDate, String endDate) {
		try {
			arrayList = Time.getEveryDay(beginDate, endDate);
			parentDocumentsdataservice = RMIHelper.getPaymentOrderdataservice();
		} catch (RemoteException | ParseException e) {
			e.printStackTrace();
		}
		
		int k = arrayList.size();
		String date;
		ArrayList<PaymentOrderPO> temp;
		paymentOrderPOs = new ArrayList<PaymentOrderPO>();
		
		for (int i = 0; i < k; i++) {
			date = arrayList.get(i);
			
			try {
				javaBean1 = parentDocumentsdataservice.findB(date);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			temp = (ArrayList<PaymentOrderPO>)javaBean1.getObject();
			paymentOrderPOs.addAll(temp);
		}
		
		javaBean1.setObject(paymentOrderPOs);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireCostAndIncomeTable() {
		//调用数据层方法，从表中读取数据（每次生成付款单和收款单都更新表）
//		javaBean1 = StatisAnalydataservice.
		
		return null;
	}
	
	public static void updateCostAndIncomeTable(double amount, String costOrIncome) {
		
	}

}
