package com.yzj.seal.ibank.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.alibaba.druid.util.StringUtils;

/**
 * 消息处理在工具类
 * 
 * @author WB000241
 */
public class MsgTranslateUtils {
	public static Logger logger = Logger.getLogger(MsgTranslateUtils.class);
	private static MsgTranslateUtils msgTranslateUtils = null;
	private static Properties properties=new Properties();
	private static InputStream resourceAsStream = MsgTranslateUtils.class.getClassLoader().getResourceAsStream("bootpro.properties");
	private JdbcTemplate template = null;
	private static final Object lock = new Object();

	private MsgTranslateUtils() {
	}

	public static MsgTranslateUtils getInstance() {
		// 提高性能
		if (null == msgTranslateUtils) {
			synchronized (lock) {
				// 创建单例
				if (null == msgTranslateUtils) {
					msgTranslateUtils = new MsgTranslateUtils();
				}
			}
		}
		return msgTranslateUtils;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.template = jdbcTemplate;
	}




	/**
	 * 构建一个指定位数在id
	 * 
	 * @param len
	 * @return
	 */
	public synchronized String buildOnlyId(int len) {
		UUID randomUUID = UUID.randomUUID();
		String str = randomUUID.toString();
		String onlyId = str.substring(0, len);
		return onlyId;
	}



	public String getLocalhostAdd() throws UnknownHostException {
		InetAddress localHost = Inet4Address.getLocalHost();
		String hostAddress = localHost.getHostAddress();
		logger.info("获取本机地址:" + hostAddress);
		return hostAddress;
	}

	public Map<String, Object> getCacheMap(String mapName) {
		Map<String, Object> result = new HashMap<String, Object>();	
	
			try {
				DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
				DocumentBuilder newDocumentBuilder = builder.newDocumentBuilder();
				InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(Worn_xiaoConstant.StaticMap.getCode());
				Document doc = newDocumentBuilder.parse(resourceAsStream);
				NodeList senderMaps = doc.getElementsByTagName(mapName);
				for (int i = 0; i < senderMaps.getLength(); i++) {
					Node item = senderMaps.item(i);
				    NodeList childNodes = item.getChildNodes();
				    for(int j=0;j<childNodes.getLength();j++){
				    	Node item2 = childNodes.item(j);
				    	if(item2.getNodeName().equalsIgnoreCase("kev-val")){
				    		NamedNodeMap attributes2 = item2.getAttributes();
				    		Node namedItem = attributes2.getNamedItem("key");
				    		Node namedItem2 = attributes2.getNamedItem("val");
				    		String nodeValue = namedItem.getNodeValue();
				    		String nodeValue2 = namedItem2.getNodeValue();
				    		result.put(nodeValue, nodeValue2);
				    	}
				    }
				}
			} catch (ParserConfigurationException e) {
				logger.error("解析配置错误" + e.getMessage());
				throw new RuntimeException("解析配置错误" + e.getMessage());
			} catch (IOException e) {
				logger.error("IO错误" + e.getMessage());
				throw new RuntimeException("IO错误" + e.getMessage());
			} catch (SAXException e) {
				logger.error("文件解析错误" + e.getMessage());
				throw new RuntimeException("文件解析错误" + e.getMessage());
			}
		return result;
	}
	
	/**
	 * 获取缓存标志 判断是否有缓存
	 * @return boolean
	 */
	public boolean isRedis(){
		Object object = Worn_xiaoConstant.redisMap.get("isredis");
		logger.info("缓存标志:"+object);
		Boolean isRedis=new Boolean(object.toString());
		return isRedis.booleanValue();
	}
}
