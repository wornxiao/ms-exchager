package com.yzj.seal.ibank.esbhEntity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ESBServices{
	private String host;
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	private int port;
    public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	private List<ESBService> service=new ArrayList<ESBService>();

	public List<ESBService> getService() {
		return service;
	}

	public void setService(List<ESBService> service) {
		this.service = service;
	}

	
}
