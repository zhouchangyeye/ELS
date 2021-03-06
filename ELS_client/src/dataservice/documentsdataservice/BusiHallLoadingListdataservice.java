package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.BusiHallLoadingListPO;
import state.ResultMessage;
/**
 * @author 朱俊文
 * 该接口提供与装车单相关的数据层方法
 */
 public interface BusiHallLoadingListdataservice extends ParentDocumentsdataservice{
 
	
	 
	/**
	 * 前置：营业厅业务员已输入所有参数
	 * 后置：增加一个装车单，更新变动到PO
     * @param id
	 * @param bhid
	 * @param tlid
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param vid
	 * @param f
	 * @param Jzy
	 * @param Yyy
	 * @return 一个装车单
	 */
	public ResultMessage addLoadingList(BusiHallLoadingListPO loadingListPO) throws
	RemoteException;
	
	/**
	 * 前置：要删除的装车单在PO中有记录
	 * 后置：删除多个装车单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException;
	
	/**
	 * 前置：要查询的装车单在PO中有记录
	 * 后置：根据时间查询某装车单,返回装车单PO信息给业务逻辑层
	 * @param id
	 * @return 装车单信息
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * 前置：要查询的装车单在PO中有记录
	 * 后置：根据时间查询某装车单,返回装车单PO信息
	 * @param time
	 * @return 装车单列表
	 */
	public JavaBean1 findB(String time) throws RemoteException;
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public ResultMessage update(BusiHallLoadingListPO loadingListPO) throws RemoteException;
	
	public String generateId(String date) throws RemoteException;
	
	public String generateTruckNum(String firstPart) throws RemoteException;
	
 }
