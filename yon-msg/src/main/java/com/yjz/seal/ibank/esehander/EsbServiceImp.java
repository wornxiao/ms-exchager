package com.yjz.seal.ibank.esehander;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.StringUtils;
import com.yjz.seal.ibank.esehander.AbstractEsbHandler;
import com.yzj.seal.ibank.common.ISendToSystem;
import com.yzj.seal.ibank.esbhEntity.ResponseParser;
import com.yzj.seal.ibank.esbhEntity.Service;
import com.yzj.seal.ibank.esbhEntity.ServiceAddress;
import com.yzj.seal.ibank.utils.MsgTranslateUtils;
import com.yzj.seal.ibank.utils.Worn_xiaoConstant;

public class EsbServiceImp implements IEsbService {
	Logger logger = Logger.getLogger(EsbServiceImp.class);

	@SuppressWarnings("unchecked")
	public Object sendMsg(String serviceId, Object msgParam) throws Exception {
		Map<String, Object> result=null;
		Service serviceConfig = (Service) AbstractEsbHandler.esbSerConfigs.get(serviceId);
		String classname = serviceConfig.getValidClass();
		Class<?> clsObj = Class.forName(classname);
		logger.info("参与校验的类是 " + clsObj);
		AbstractEsbSendMethod esbSendMethod = (AbstractEsbSendMethod) clsObj.newInstance();
		Object rebuild = esbSendMethod.buildMsg(serviceConfig, msgParam);
		if(null==rebuild){
			logger.error("请根据日志检查 Service.xml文件的配置 serviceId 为"+serviceId);
			throw new RuntimeException("请根据日志检查 Service.xml文件的配置 serviceId 为"+serviceId);
		}
		ServiceAddress serviceAddress = serviceConfig.getServiceAddress();
		String sysName = serviceAddress.getDestinationSys();
		String clapath = (String) Worn_xiaoConstant.senderMap.get(sysName);
		if(StringUtils.isEmpty(clapath)){
			logger.error("不存在目标系统 "+sysName+"对象的报文发送类"+ clapath);
			throw new RuntimeException("不存在目标系统 "+sysName+"对象的报文发送类"+ clapath);
		}
		logger.error("目标系统 "+sysName+"对象的报文发送类"+ clapath);
		Class<?> cla=Class.forName(clapath);
		logger.info("目标发送类 " + cla);
		ISendToSystem sendToSystem=(ISendToSystem) cla.newInstance();
		Object send = sendToSystem.send(serviceConfig, rebuild);
		logger.info("真实响应的报文呢:"+send );
		ResponseParser resParser = serviceConfig.getResParser();
		String msgType = resParser.getMsgType();
		String methodName = resParser.getParseMethod();
		if(StringUtils.isEmpty(msgType)){
			logger.error("请配置解析报文类型:"+msgType);
			throw new RuntimeException("不存在目标系统 "+sysName+"对象的报文发送类"+ clapath);
		}
		logger.info("msgType="+msgType+" methodName="+methodName);
		String object = (String) Worn_xiaoConstant.recivMap.get(msgType);
		Class<?> classd = Class.forName(object);
		Object newInstance = classd.newInstance();
		Method method = classd.getMethod(methodName,new Class[]{Object.class});
		method.invoke(newInstance, send);
		logger.info("解析好的报文:"+ result);
		return result;
	}
}
