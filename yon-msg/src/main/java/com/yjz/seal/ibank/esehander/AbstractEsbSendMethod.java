package com.yjz.seal.ibank.esehander;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.StringUtils;
import com.yzj.seal.ibank.esbhEntity.MsgModel;
import com.yzj.seal.ibank.esbhEntity.MsgNote;
import com.yzj.seal.ibank.esbhEntity.Num;
import com.yzj.seal.ibank.esbhEntity.Service;
import com.yzj.seal.ibank.esbhEntity.ServiceAddress;
import com.yzj.seal.ibank.utils.MsgTranslateUtils;
import com.yzj.seal.ibank.utils.Worn_xiaoConstant;

public abstract class AbstractEsbSendMethod implements IEebServiceMethod {
	Logger log = Logger.getLogger(AbstractEsbSendMethod.class);
	// 这里加载核心的ip地址与端口号

	public String buildMsg(Service service, Object obj) {
		String result = null;
		if (!validateParam(service, obj))
			return result;
		if (obj instanceof List)
			return buildRealList(service, (List<Object>) obj);
		if (obj instanceof Map)
			return buildRealMmap(service, (Map<?, ?>) obj);
		return result;
	}

	private String buildRealMmap(Service service, Map<?, ?> mmp) {
		MsgNote msgNote = service.getMsgNote();
		List<Num> num = msgNote.getNum();
		log.info("num " + num);
		List<Object> list = new ArrayList<Object>();
		for (Num num2 : num) {
			String realkey = num2.getRealkey();
			Object object = mmp.get(num2.getName());
			int index = Integer.valueOf(realkey);
			list.add(index, object);
		}
		if (list.size() > 0)
			return buildRealList(service, list);
		return null;
	}

	private String buildRealList(Service service, List<Object> realvalues) {
		MsgModel msgModel = service.getMsgModel();
		String modelValue = msgModel.getModelValue();
		log.info("报文模板    " + modelValue);
		Object[] array = realvalues.toArray();
		String msg = MessageFormat.format(modelValue, array);
		int length = msg.trim().getBytes().length;
		String header = createMsg(length);
		String realmsg = header + msg.trim();
		log.info("格式化 后的报文  " + realmsg);
		if (realvalues.size() > 0)
			return realmsg;
		return null;
	}

	private String createMsg(int length) {
		String s = "" + length;
		int len = Integer.valueOf(Worn_xiaoConstant.MsgHeader.getCode()) - s.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
			buffer.append("0");
		}
		buffer.append(s);
		return buffer.toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean validateParam(Service service, Object obj) {
		if (!commonValidate(service, obj))
			return false;
		if (obj instanceof Map)
			return validateMap((Map<String, Object>) obj);
		return validateList((List) obj);
	}

	private boolean commonValidate(Service service, Object obj) {
		String validClass = service.getValidClass();
		if (StringUtils.isEmpty(validClass)) {
			log.error("Service.xml 中 validClass 报文校验类是否配置");
			return false;
		}
		ServiceAddress serviceAddress = service.getServiceAddress();
		String destinationSys = serviceAddress.getDestinationSys();
		if (StringUtils.isEmpty(destinationSys)) {
			log.error("Service.xml 中 destinationSys 报文校验类是否配置");
			return false;
		}
		List<Num> num = service.getMsgNote().getNum();
		if (num.size() == 0) {
			log.error("Service.xml配置文件中的num元素没有配置");
			return false;
		}
		if (obj instanceof Map) {
			Map<?, ?> mmp = (Map<?, ?>) obj;
			Collection<?> values = mmp.values();
			if (values.size() != num.size()) {
				log.error("Service.xml配置文件中的num元素的数量 与传入的参数数量不一致");
				return false;
			}
		}
		if (obj instanceof List) {
			List<?> li = (List<?>) obj;
			if (li.size() != num.size()) {
				log.error("Service.xml配置文件中的num元素的数量 与传入的参数数量不一致");
				return false;
			}
		}
		return true;
	}

	public abstract boolean validateMap(Map<String, Object> args);

	public abstract boolean validateList(List<Object> valus);

}
