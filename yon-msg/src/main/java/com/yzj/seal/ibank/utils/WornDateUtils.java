package com.yzj.seal.ibank.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WornDateUtils {
	private static  WornDateUtils msgTranslateUtils=null;
	private static final Object lock=new  Object();
	private WornDateUtils(){ }
	
	public static WornDateUtils getInstance(){
		//提高性能
			if(null==msgTranslateUtils){
				synchronized (lock) {
					//创建单例
					if(null==msgTranslateUtils){
					    msgTranslateUtils=new WornDateUtils();
					}
				}
			}
		return msgTranslateUtils;
	}
	
	/**
	 * 
	 * @param date 日期
	 * @param pattern 格式串
	 * @return 日期转化成字符串
	 */
	public synchronized String getDate(Date date,String pattern){
		DateFormat format=new SimpleDateFormat(pattern);
		String format2 = format.format(date);
		return format2;
	}
}
