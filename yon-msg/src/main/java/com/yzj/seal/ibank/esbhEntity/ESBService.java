package com.yzj.seal.ibank.esbhEntity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class ESBService {
	private String serviceId;
	private String serviceTitle;
	private String serviceName;
	private String validClass;
	private MsgNote msgNote;
	private MsgModel msgModel;
	
	public MsgModel getMsgModel() {
		return msgModel;
	}
	public MsgNote getMsgNote() {
		return msgNote;
	}

	public String getServiceId() {
		return serviceId;
	}

	public String getValidClass() {
		return validClass;
	}
	
	@XmlAttribute
	public void setValidClass(String validClass) {
		this.validClass = validClass;
	}
	public String getServiceName() {
		return serviceName;
	}
	
	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setMsgModel(MsgModel msgModel) {
		this.msgModel = msgModel;
	}
	
	public void setMsgNote(MsgNote msgNote) {
		this.msgNote = msgNote;
	}


	@XmlAttribute
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@XmlAttribute
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@XmlAttribute
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

}
