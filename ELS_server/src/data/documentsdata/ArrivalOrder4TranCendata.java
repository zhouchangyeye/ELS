package data.documentsdata;

import java.util.ArrayList;

import po.documentsPO.ArrivalOrder4TranCenPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.ArrivalOrder4TranCendataservice;


public class ArrivalOrder4TranCendata implements ArrivalOrder4TranCendataservice{

	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addArrivalOrder4TranCen(
			ArrivalOrder4TranCenPO arrivalOrder4TranCenPO) {
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
	public ArrayList<ArrivalOrder4TranCenPO> findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenPO> findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenPO> findC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateStartAdd() {
		// TODO Auto-generated method stub
		return null;
	}

}