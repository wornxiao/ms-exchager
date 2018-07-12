package com.yzj.seal.ibank.esbhEntity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Services{
	private List<Service> service=new ArrayList<Service>();

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}

	

	
}
