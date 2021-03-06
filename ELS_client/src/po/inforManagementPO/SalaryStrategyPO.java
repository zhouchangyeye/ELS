package po.inforManagementPO;

import java.io.Serializable;
import state.PayType;
import state.Position;

public class SalaryStrategyPO implements Serializable{
	private Position position;
	private PayType payType;
	private double payAmount;
	private String percentage;
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public PayType getPayType() {
		return payType;
	}
	public void setPayType(PayType payType) {
		this.payType = payType;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	
}
