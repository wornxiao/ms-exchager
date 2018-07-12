package com.yjz.seal.ibank.resPaser;

import java.util.Map;

public interface IResonpsePaser {
	
	/**
	 * 解析响应报文
	 * @param obj
	 * @return
	 */
	public Map<String,Object> parResMsg(Object args);
}
