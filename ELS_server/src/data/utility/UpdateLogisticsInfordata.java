package data.utility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import state.ResultMessage;
import dataservice.utilitydataservice.UpdateLogisticsInfordataservice;

public class UpdateLogisticsInfordata extends UnicastRemoteObject implements UpdateLogisticsInfordataservice{

	public UpdateLogisticsInfordata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage update(String id, String description) {
		// TODO Auto-generated method stub
		return null;
	}

}
