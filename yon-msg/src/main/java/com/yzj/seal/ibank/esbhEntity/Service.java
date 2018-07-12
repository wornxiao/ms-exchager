package com.yzj.seal.ibank.esbhEntity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Service {
	private String serviceId;
	private String serviceTitle;
    private String serviceName;
	private String validClass;
	private MsgNote msgNote;
	private ServiceAddress serviceAddress;
	private ResponseParser resParser;

	
	private MsgModel msgModel;
	public MsgModel getMsgModel() {
		return msgModel;
	}
	public MsgNote getMsgNote() {
		return msgNote;
	}
	public ResponseParser getResParser() {
		return resParser;
	}
	
	public ServiceAddress getServiceAddress() {
		return serviceAddress;
	}
	
	public String getServiceId() {
		return serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	
	public String getServiceTitle() {
		return serviceTitle;
	}
	public String getValidClass() {
		return validClass;
	}
	
	public void setMsgModel(MsgModel msgModel) {
		this.msgModel = msgModel;
	}


	public void setMsgNote(MsgNote msgNote) {
		this.msgNote = msgNote;
	}

	
	
	public void setResParser(ResponseParser resParser) {
		this.resParser = resParser;
	}
	public void setServiceAddress(ServiceAddress serviceAddress) {
		this.serviceAddress = serviceAddress;
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


	@XmlAttribute
	public void setValidClass(String validClass) {
		this.validClass = validClass;
	}

}
