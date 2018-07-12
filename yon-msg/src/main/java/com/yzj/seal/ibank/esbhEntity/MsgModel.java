package com.yzj.seal.ibank.esbhEntity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MsgModel {
	
	private String modelName;
	private String modelValue;
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelValue() {
		return modelValue;
	}
	public void setModelValue(String modelValue) {
		this.modelValue = modelValue;
	}
}
