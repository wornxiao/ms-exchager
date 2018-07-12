package com.yjz.seal.ibank.esehander;


import com.yzj.seal.ibank.esbhEntity.Service;

public interface IEebServiceMethod {
 
 
  /**
   * 组装报文
   * @param args
   * @return
   */
  public String buildMsg(Service service, Object maps);
 
  
}
