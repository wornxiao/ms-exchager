package com.yzj.seal.ibank.common;

import com.yzj.seal.ibank.esbhEntity.Service;

public interface ISendToSystem {
	 /**
	   * 向esb发送参数的方法
	   * @param args
	   * @return
	 * @throws Exception 
	   */
	  public Object send(Service service,Object args) throws Exception;
}
