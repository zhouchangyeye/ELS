package vo.lineitemVO.orderlineitemVO;

import state.ApproState;
import state.ExpressType;

public class OrderlineitemVO {
	private String id;
	private String generateDate;
	private String senderAdd;
	private String AddresseeAdd;
	private double totalCost;
    private ExpressType expressType;
    private ApproState approState;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGenerateDate() {
		return generateDate;
	}
	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}
	public String getSenderAdd() {
		return senderAdd;
	}
	public void setSenderAdd(String senderAdd) {
		this.senderAdd = senderAdd;
	}
	public String getAddresseeAdd() {
		return AddresseeAdd;
	}
	public void setAddresseeAdd(String addresseeAdd) {
		AddresseeAdd = addresseeAdd;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public ExpressType getExpressType() {
		return expressType;
	}
	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}
	public ApproState getApproState() {
		return approState;
	}
	public void setApproState(ApproState approState) {
		this.approState = approState;
	}
    
}
