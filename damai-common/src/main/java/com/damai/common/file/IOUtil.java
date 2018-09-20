package com.damai.common.file;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO流工具类
 *  
 * @author felix.chen
 * @date 2017年7月26日 下午1:09:23 
 *
 */
public class IOUtil {
	/**
	 * 关闭一个或多个流对象
	 * 
	 * @param closeables 可关闭的流对象列表
	 * @throws IOException  
	 * @author felix.chen
	 * @date 2017年7月26日 下午1:09:56 
	 *
	 */
	public static void close(Closeable... closeables) throws IOException {
		if (closeables != null) {
			for (Closeable closeable : closeables) {
				if (closeable != null) {
					closeable.close();
				}
			}
		}
	}

	/**
	 * 关闭一个或多个流对象
	 * 
	 * @param closeables  可关闭的流对象列表
	 * @author felix.chen
	 * @date 2017年7月26日 下午1:10:48 
	 *
	 */
	public static void closeQuietly(Closeable... closeables) {
		try {
			close(closeables);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
