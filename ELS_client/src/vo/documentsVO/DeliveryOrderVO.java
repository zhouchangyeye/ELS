package vo.documentsVO;

import state.ApproState;

public class DeliveryOrderVO {
	private String ID;
    private String arrivalDate;
    private String orderID;
    private String deliverier;
    private String generateTime;
    private ApproState approState;
    
	public ApproState getApproState() {
		return approState;
	}
	public void setApproState(ApproState approState) {
		this.approState = approState;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getDeliverier() {
		return deliverier;
	}
	public void setDeliverier(String deliverier) {
		this.deliverier = deliverier;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
}
