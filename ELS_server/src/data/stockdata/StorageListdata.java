package data.stockdata;

import java.util.ArrayList;

import po.lineitemPO.stocklineitemPO.StorageListlineitemPO;
import po.stockPO.StorageListPO;
import state.ResultMessage;
import dataservice.stockdataservice.StorageListdataservice;


public class StorageListdata implements StorageListdataservice {

	@Override
	public StorageListPO add(String id4obo, String time, String id4e,
			String id4to, String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4obo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageListPO modify(String id, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageListPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageListlineitemPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}