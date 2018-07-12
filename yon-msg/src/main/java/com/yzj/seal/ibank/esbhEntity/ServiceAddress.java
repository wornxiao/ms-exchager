package com.yzj.seal.ibank.esbhEntity;

import javax.xml.bind.annotation.XmlAttribute;

public class ServiceAddress {
	private String host;
	private int port;
	private String destinationSys;
	
	public String getDestinationSys() {
		return destinationSys;
	}
	public String getHost() {
		return host;
	}

	
	public int getPort() {
		return port;
	}
	public void setDestinationSys(String destinationSys) {
		this.destinationSys = destinationSys;
	}
	@XmlAttribute
	public void setHost(String host) {
		this.host = host;
	}
	@XmlAttribute
	public void setPort(int port) {
		this.port = port;
	}
	
}
