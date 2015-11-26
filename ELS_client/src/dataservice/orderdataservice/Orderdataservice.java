package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import state.ResultMessage;

public interface Orderdataservice extends Remote{
	/**
	 * ǰ���������������ж�������
     * ��������������һ������������ͬ����PO
	 * @param sender
	 * @param addressee
	 * @param desti
	 * @param startingPlace
	 * @param eType
	 * @param name
	 * @param id
	 * @param num
	 * @return
	 */
	public OrderPO add(OrderPO orderPO) throws RemoteException;
	
	/**
	 * ǰ��������Ҫɾ���Ķ�����PO���м�¼
	 * ����������ɾ��һ������������PO
	 * @param orderid
	 */
    public ResultMessage deleteOne(String id) throws RemoteException;
    
    public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
    /**
     * ǰ��������
     * ��������������id��ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public OrderPO findA(String id) throws RemoteException;
    
    /**
     * ǰ��������
     * ��������������ʱ���ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public ArrayList<OrderlineitemPO> findB(String date) throws RemoteException;
    
    /**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public ResultMessage update(OrderPO orderPO) throws RemoteException;
	
	public OrderlineitemPO getOrderlineitemPO(String id) throws RemoteException;
	
	public void generateId() throws RemoteException;

}