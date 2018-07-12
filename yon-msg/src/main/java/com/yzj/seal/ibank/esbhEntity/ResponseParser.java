package com.yzj.seal.ibank.esbhEntity;

import javax.xml.bind.annotation.XmlAttribute;

public class ResponseParser {
	private String msgType;
	private String parseMethod;

	public String getMsgType() {
		return msgType;
	}
	@XmlAttribute
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getParseMethod() {
		return parseMethod;
	}
	@XmlAttribute
	public void setParseMethod(String parseMethod) {
		this.parseMethod = parseMethod;
	}

}
