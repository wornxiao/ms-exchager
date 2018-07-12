package com.yjz.seal.ibank.esehander;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.yzj.seal.ibank.esbhEntity.Service;
import com.yzj.seal.ibank.esbhEntity.Services;


/**
 * 交给spring容器进行管理
 */
public class AbstractEsbHandler {
	@SuppressWarnings("unchecked")
	public static final Map<String, Object> esbSerConfigs = new ConcurrentHashMap<String, Object>();
	Logger logger = Logger.getLogger(AbstractEsbHandler.class);
	public static Services esbServices = null;

	@SuppressWarnings("restriction")
	public AbstractEsbHandler() {
		try {
			@SuppressWarnings("restriction")
			JAXBContext jaxbContext = JAXBContext.newInstance(Services.class);
			@SuppressWarnings("restriction")
			Unmarshaller unmash = jaxbContext.createUnmarshaller();
			InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("Service.xml");
			logger.info("resourceAsStream " + resourceAsStream);
			if (null == resourceAsStream) {
				logger.error(this.getClass().getSimpleName() + "Service.xml 文件加载失败  ");
			}
			esbServices = (Services) unmash.unmarshal(resourceAsStream);
			List<Service> service = esbServices.getService();
			if (service.size() > 0) {
				logger.info("ESBService " + service.size());
				for (Service esbs : service) {
					// 把各个ESB的接口准备好
					esbSerConfigs.put(esbs.getServiceId(), esbs);
				}
				logger.info(this.getClass() + " " + esbSerConfigs.keySet().size());
			}
		} catch (Exception e) {
			logger.error(this.getClass() + " " + e.getMessage());
		}

	}
}
