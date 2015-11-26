package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;

import po.StatisAnalyPO.BusinessSituationPO;
import po.StatisAnalyPO.CostAndIncomePO;

/**
 * 该类处理和查看统计分析有关的数据层方法
 * @author zt
 *
 */
public interface StatisAnalydataservice extends Remote{
	/**
	 * 前置条件：
	 * 后置条件：生成经营情况表返回给逻辑层
	 * @param StartDate
	 * @param EndDate
	 * @return
	 */
	public BusinessSituationPO BS(String StartDate,String EndDate);
	
	/**
	 * 前置条件：
	 * 后置条件：生成截止当前日期的成本收益表（总收入、总支出、总利润=总收入-总支出）返回给逻辑层
	 * @return
	 */
	public CostAndIncomePO CAI();
	
	/**
	 * 前置条件：已知总收入和总支出
	 * 后置条件：根据总收入和总支出计算总利润返回给逻辑层
	 * @param income
	 * @param cost
	 * @return
	 */
	public double profit(double income,double cost);
}
