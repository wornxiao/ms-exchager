package com.yzj.seal.ibank.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.yzj.seal.ibank.esbhEntity.Service;
import com.yzj.seal.ibank.esbhEntity.ServiceAddress;

/**
 * 对接ESB的接口
 * 
 * @author WB000241
 */
public class SendToESBSendHandler implements ISendToSystem {
	Logger logger = Logger.getLogger(SendToESBSendHandler.class);

	private Socket socket;

	public Object send(Service service, Object msg) {
		StringBuffer buffer = new StringBuffer();
		try {
			ServiceAddress serviceAddress = service.getServiceAddress();
			String host = serviceAddress.getHost();
			logger.info("host " + host);
			int port = serviceAddress.getPort();
			logger.info("port " + port);
			socket = new Socket(host, port);
			OutputStream outs = socket.getOutputStream();
			BufferedOutputStream bufed = new BufferedOutputStream(outs);
			byte[] bytes = msg.toString().getBytes();
			bufed.write(bytes);
			bufed.flush();
			InputStream inputStream = socket.getInputStream();
			BufferedInputStream stream = new BufferedInputStream(inputStream);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = stream.read(buf)) != -1) {
				buffer.append(new String(buf, 0, len));
			}
			bufed.close();
			logger.info("buffer.toString() " + buffer.toString());
		} catch (IOException exception) {
			logger.error("对接ESB的socket通信接口异常 " + exception.getMessage());
		}
		return buffer.toString();
	}

}
