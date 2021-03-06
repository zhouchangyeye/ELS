package businesslogic.inforManagementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.inforManagementPO.SalaryStrategyPO;
import state.Position;
import state.ResultMessage;
import vo.inforManagementVO.SalaryStrategyVO;
import dataservice.inforManagementdataservice.StaffInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.userManagementbl.UserManagement;
import businesslogicservice.inforManagementblservice.StaffInforblservice;

public class StaffInfor implements StaffInforblservice{
	private StaffInfordataservice staffInfordataservice;
	private SalaryStrategyPO salaryStrategyPO;
	private SalaryStrategyVO salaryStrategyVO;
	private ArrayList<SalaryStrategyPO> salaryStrategyPOs;
	private ArrayList<SalaryStrategyVO> salaryStrategyVOs;
	private UserManagement userManagement;
	private JavaBean1 javaBean1;
	private ResultMessage resultMessage;
	
	public StaffInfor() {
		try {
			staffInfordataservice = RMIHelper.getStaffInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireA(String Id) {
		userManagement = new UserManagement();
		javaBean1 = userManagement.inquireA(Id);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(Position position) {
		//把这一职位的所有人查出来会不会太多了，待定，可能要改
		userManagement = new UserManagement();
		javaBean1 = userManagement.inquireB(position);
		return javaBean1;
	}

	@Override
	public ResultMessage modifySalaryStrategy(ArrayList<SalaryStrategyVO> 
	salaryStrategyVOs) {
		this.salaryStrategyVOs = salaryStrategyVOs;
		salaryStrategyPOs = new ArrayList<SalaryStrategyPO>();
		int k = salaryStrategyVOs.size();
		
		for (int i = 0; i < k; i++) {
			salaryStrategyVO = salaryStrategyVOs.get(i);
			
			salaryStrategyPO = new SalaryStrategyPO();
			salaryStrategyPO.setPosition(salaryStrategyVO.getPosition());
			salaryStrategyPO.setPayType(salaryStrategyVO.getPayType());
			salaryStrategyPO.setPayAmount(salaryStrategyVO.getPayAmount());
			salaryStrategyPO.setPercentage(salaryStrategyVO.getPercentage());
			
			salaryStrategyPOs.add(salaryStrategyPO);
		}
		
		try {
			resultMessage = staffInfordataservice.updateSalaryStrategy(salaryStrategyPOs);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//调用数据层方法，修改工资策略
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireSalaryStrategy() {
		try {
			javaBean1 = staffInfordataservice.getSalaryStrategy();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//调用数据层
		salaryStrategyPOs = (ArrayList<SalaryStrategyPO>)javaBean1.getObject();
		salaryStrategyVOs = new ArrayList<SalaryStrategyVO>();
		
		if (javaBean1.getResultMessage() == ResultMessage.Fail) {
			return javaBean1;
		}
		
		int k = salaryStrategyPOs.size();
		for (int i = 0; i < k; i++) {
			salaryStrategyPO = salaryStrategyPOs.get(i);
			
			salaryStrategyVO = new SalaryStrategyVO();
			salaryStrategyVO.setPosition(salaryStrategyPO.getPosition());
			salaryStrategyVO.setPayType(salaryStrategyPO.getPayType());
			salaryStrategyVO.setPayAmount(salaryStrategyPO.getPayAmount());
			salaryStrategyVO.setPercentage(salaryStrategyPO.getPercentage());
			
			salaryStrategyVOs.add(salaryStrategyVO);
		}
		
		javaBean1.setObject(this.salaryStrategyVOs);
		return javaBean1;
	}
	
}
