package com.damai.common.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合工具类
 *  
 * @author felix.chen
 * @date 2017年7月19日 下午6:40:13 
 *
 */
public class ListTool {
	
	/**
	 * 分割集合
	 * 
	 * @param list 要分割的集合
	 * @param pageSize 每个集合的条数
	 * @return  分割后的集合
	 * @author felix.chen
	 * @date 2017年7月19日 下午6:40:36 
	 *
	 */
	public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
		//分割后的集合
		List<List<T>> listArray = new ArrayList<List<T>>();
		//临时集合，用来保存每份集合
		ArrayList<T> al = new ArrayList<T>();
		//遍历要分割的集合
		for (T x : list) {
			al.add(x);
			//如果临时集合放满了，就新创建一个
			if (pageSize == al.size()) {
				listArray.add(al);
				al = new ArrayList<T>();
			}
		}
		if (0 != al.size())
			listArray.add(al);
		return listArray;
	}
    
}
