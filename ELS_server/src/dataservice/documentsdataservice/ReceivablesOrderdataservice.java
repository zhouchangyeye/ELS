package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.ReceivablesOrderPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;


public interface ReceivablesOrderdataservice extends ParentDocumentsdataservice{
	/**
	 * 
	 * @param date4RO
	 * @param amount4RO
	 * @param courier4RO
	 * @param barCode
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的收款单信息
	 */
	public ResultMessage add(ReceivablesOrderPO receivablesOrderPO) throws 
	RemoteException;

	/**
	 * 
	 * @param id4courier
	 * @param date
	 * 前置条件：要删除的收款单信息在持久化数据中有记录
	 * 后置条件：删除多条收款单信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
	
	/**
	 * 
	 * @param keyword 
	 * @return
	 * 前置条件：要查询的收款单信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	public JavaBean1 findB(String date) throws RemoteException;

	public JavaBean1 findC(String busiHallID) throws RemoteException;

	/**
	 * 前置条件：收款单信息处理完成 
	 * 后置条件：结束这次收款单信息处理，更新数据持久化对象
	 */
	public ResultMessage update(ReceivablesOrderPO receivablesOrderPO) throws RemoteException;
	
	public double generateAmount(ArrayList<String> orderIdList)  throws RemoteException;
	
	public String generateId(String date) throws RemoteException;
}
