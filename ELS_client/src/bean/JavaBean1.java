package bean;

import state.ResultMessage;

public class JavaBean1 {
	private Object Object;
	private ResultMessage resultMessage;
	
	public Object getObject() {
		return Object;
	}
	public void setObject(Object Object) {
		this.Object = Object;
	}
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Class getObjectClass() {
		return Object.getClass();
	}
	
}
