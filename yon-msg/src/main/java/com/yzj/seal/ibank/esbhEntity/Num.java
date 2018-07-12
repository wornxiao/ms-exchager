package com.yzj.seal.ibank.esbhEntity;

import javax.xml.bind.annotation.XmlAttribute;

public class Num {
    private String name;
    private String realkey;
    private String value;
    
	public String getName() {
		return name;
	}
	public String getRealkey() {
		return realkey;
	}
	@XmlAttribute
	public void setRealkey(String realkey) {
		this.realkey = realkey;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
