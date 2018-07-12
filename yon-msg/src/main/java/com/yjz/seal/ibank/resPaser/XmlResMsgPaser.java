package com.yjz.seal.ibank.resPaser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.yzj.seal.ibank.utils.Worn_xiaoConstant;


public class XmlResMsgPaser implements IResonpsePaser {
	Logger logger=Logger.getLogger(XmlResMsgPaser.class);
	public Map<String, Object> parResMsg(Object args) {
		if(null==args) return null;
		Map<String, Object> result=new HashMap<String, Object>();
		try {
			logger.info("报文解析方法 开始解析:parResMsg");
			String xmltext=args.toString().substring(
					Integer.valueOf(Worn_xiaoConstant.MsgHeader.getCode()));
			Document read = DocumentHelper.parseText(xmltext);
			Element rootElement = read.getRootElement();
			List<?> elements = rootElement.elements();
			for(Object element:elements){
				Element ele=(Element) element;
				String name = ele.getName();
				if(Worn_xiaoConstant.msgBoy.getCode().equalsIgnoreCase(name)){
					List<?> elements2 = ele.elements();
					for(Object obj:elements2){
						Element elec=(Element) obj;
						result.put(elec.getName(), elec.getText());
					}
				}
			}
		} catch (DocumentException e) {
			logger.info("文档解析异常 "+ e.getMessage());
		    throw new RuntimeException("文档解析异常 "+ e.getMessage());
		}
		return result;
	}

}
