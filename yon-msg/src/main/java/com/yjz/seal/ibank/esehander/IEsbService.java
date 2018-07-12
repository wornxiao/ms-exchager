package com.yjz.seal.ibank.esehander;

/**
 * esb服务
 * @author WB000241
 *
 */
public interface IEsbService {
	
	/**
	 * 指定哪个服务来发送报文
	 * @param arg
	 * @return
	 * @throws Exception 
	 */
	public Object sendMsg(String serviceId,Object msgParam) throws Exception;
}