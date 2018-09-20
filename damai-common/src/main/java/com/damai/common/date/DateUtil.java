package com.damai.common.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *  
 * @author felix.chen
 * @date 2017年7月26日 上午11:21:42 
 *
 */
public class DateUtil {

	static Format YYYY_MM = new SimpleDateFormat("yyyy-MM");
	static Format YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 获取昨天年月字符串
	 * 
	 * @return  年月字符串
	 * @author felix.chen
	 * @date 2017年7月26日 下午3:35:29 
	 *
	 */
	public static String getYesterdayYYYY_MM() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DAY_OF_MONTH, -1);// 今天-1天
		Date yesterday = c.getTime();
		String dataFormat = YYYY_MM.format(yesterday);
		return dataFormat;
	}

	/**
	 * 获取昨天年月日字符串
	 * 
	 * @return 年月日字符串 
	 * @author felix.chen
	 * @date 2017年7月26日 下午3:35:58 
	 *
	 */
	public static String getYesterdayYYYY_MM_DD() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DAY_OF_MONTH, -1);// 今天-1天
		Date yesterday = c.getTime();
		String dataFormat = YYYY_MM_DD.format(yesterday);
		return dataFormat;
	}
	
//	public static void main(String[] args) {
//		String dataFormat1 =getYesterdayYYYY_MM();
//		getYesterdayYYYY_MM_DD();
//		
//	}
}
