package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.PaymentOrderPO;
import po_client.inforManagementPO.BankAccountPO;
import po_client.lineitemPO.documentslineitemPO.PaymentOrderlineitemPO;
import state.ResultMessage;

public interface PaymentOrderdataservice {
	
	public BankAccountPO addPaymentAccount(String accountName);
	
	/**
	 * 
	 * @param date4PaymentOrder
	 * @param amount4PaymentOrder
	 * @param remitter
	 * @param account4PaymentOrder
	 * @param item4Vehicles
	 * @param remark1
	 * @param remark2
	 * @return
	 * 前置条件：财务人员已经被授权和登录
	 * 后置条件：添加新的付款单信息
	 */
	public ResultMessage add(PaymentOrderPO paymentOrderPO);
	/**
	 * 
	 * @param id
	 * @param bussinessHall
	 * @return
	 * 前置条件：要删除的付款单信息在PO中有记录
	 * 后置条件：删除一条付款单信息
	 * 
	 */
	public ResultMessage deleteOne(String id);

	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * 前置条件：要删除的收款单信息在持久化数据中有记录
	 * 后置条件：删除多条收款单信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
//	/**
//	 * 
//	 * @param bussinessHall
//	 * @param date
//	 * @return
//	 * 前置条件：要修改的付款单信息在PO中有记录
//	 * 后置条件：修改付款单信息，并更新VO和PO
//	 */
//	public PaymentOrderPO modify(String bussinessHall,String date);
//	
	/**
	 * 
	 * @param keyword
	 * @return
	 * 前置条件：要查询的付款单信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public PaymentOrderPO findA(String id);
	
	public ArrayList<PaymentOrderlineitemPO> findB(String date);
	
	/**
	 * 前置条件：付款单信息处理完成
	 * 后置条件：结束这次付款单信息处理，更新数据持久化对象
	 */
	public ResultMessage update(PaymentOrderPO paymentOrderPO);
	
	public String generaId();
}
