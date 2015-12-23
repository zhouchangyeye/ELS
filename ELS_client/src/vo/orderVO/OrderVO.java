package vo.orderVO;

import state.ApproState;
import state.ExpressType;

public class OrderVO {
	private String senderName;
	private String senderAdd;
	private String senderCompany;
	private String senderPhoneNumber;
	private String AddresseeName;
	private String AddresseeAdd;
	private String AddresseeCompany;
	private String AddresseePhoneNumber;
	private String trueAddressee;
	private String id;
	private String goodsName;
	private String generateDate;
	private String generateTime;
	private String arrivalDate;
	private String expectedArrivalDate;
	private double weight;
	private double size;
	private double freight;
	private double packingCharge;
	private double totalCost;
	private int numOfGoods;
	private ApproState approState;
	private ExpressType expressType;
	
	public int getNumOfGoods() {
		return numOfGoods;
	}
	public void setNumOfGoods(int numOfGoods) {
		this.numOfGoods = numOfGoods;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAdd() {
		return senderAdd;
	}
	public void setSenderAdd(String senderAdd) {
		this.senderAdd = senderAdd;
	}
	public String getSenderCompany() {
		return senderCompany;
	}
	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}
	public String getSenderPhoneNumber() {
		return senderPhoneNumber;
	}
	public void setSenderPhoneNumber(String senderPhoneNumber) {
		this.senderPhoneNumber = senderPhoneNumber;
	}
	public String getAddresseeName() {
		return AddresseeName;
	}
	public void setAddresseeName(String addresseeName) {
		AddresseeName = addresseeName;
	}
	public String getAddresseeAdd() {
		return AddresseeAdd;
	}
	public void setAddresseeAdd(String addresseeAdd) {
		AddresseeAdd = addresseeAdd;
	}
	public String getAddresseeCompany() {
		return AddresseeCompany;
	}
	public void setAddresseeCompany(String addresseeCompany) {
		AddresseeCompany = addresseeCompany;
	}
	public String getAddresseePhoneNumber() {
		return AddresseePhoneNumber;
	}
	public void setAddresseePhoneNumber(String addresseePhoneNumber) {
		AddresseePhoneNumber = addresseePhoneNumber;
	}
	public String getTrueAddressee() {
		return trueAddressee;
	}
	public void setTrueAddressee(String trueAddressee) {
		this.trueAddressee = trueAddressee;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGenerateDate() {
		return generateDate;
	}
	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}
	public String getExpectedArrivalDate() {
		return expectedArrivalDate;
	}
	public void setExpectedArrivalDate(String expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getFreight() {
		return freight;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	public double getPackingCharge() {
		return packingCharge;
	}
	public void setPackingCharge(double packingCharge) {
		this.packingCharge = packingCharge;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public ApproState getApproState() {
		return approState;
	}
	public void setApproState(ApproState approState) {
		this.approState = approState;
	}
	public ExpressType getExpressType() {
		return expressType;
	}
	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}
	
	
}

