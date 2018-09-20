package com.damai.common.map;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Map对象和Bean对象互转工具类
 *  
 * @author felix.chen
 * @date 2017年6月26日 下午1:25:37 
 *
 */
public class MapUtil {
	 /**  
     * 将Map对象通过反射机制转换成Bean对象  
     *   
     * @param map 存放数据的map对象  
     * @param clazz 待转换的class  
     * @return 转换后的Bean对象  
     * @throws Exception 异常  
     */    
    public static Object mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {    
        Object obj = clazz.newInstance();    
        if(map != null && map.size() > 0) {    
            for(Map.Entry<String, Object> entry : map.entrySet()) {    
                String propertyName = entry.getKey();       //属性名  
                Object value = entry.getValue();
                //拼接属性的set方法名
                String setMethodName = "set"    
                        + propertyName.substring(0, 1).toUpperCase()  
                        + propertyName.substring(1);    
                Field field = getClassField(clazz, propertyName);    
                if(field==null)  
                    continue;  
                Class<?> fieldTypeClass = field.getType();    
                value = convertValType(value, fieldTypeClass);   
                try{  
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);   
                }catch(NoSuchMethodException e){  
                	e.getMessage();
                    e.printStackTrace();  
                }  
            }    
        }    
        return obj;    
    }  
      
    /**  
     * 获取指定字段名称查找在class中的对应的Field对象(包括查找父类)  
     *   
     * @param clazz 指定的class  
     * @param fieldName 字段名称  
     * @return Field对象  
     */    
    public static Field getClassField(Class<?> clazz, String fieldName) {    
        if(Object.class.getName().equals(clazz.getName())) {    
            return null;    
        }    
        Field[] declaredFields = clazz.getDeclaredFields();    
        for (Field field : declaredFields) {    
            if (field.getName().equals(fieldName)) {    
                return field;    
            }    
        }    
    
        Class<?> superClass = clazz.getSuperclass();    
        if(superClass != null) {// 简单的递归一下    
            return getClassField(superClass, fieldName);    
        }    
        return null;    
    }     
      
     /**  
     * 将Object类型的值，转换成bean对象属性里对应的类型值  
     *   
     * @param value Object对象值  
     * @param fieldTypeClass 属性的类型  
     * @return 转换后的值  
     */    
    public static Object convertValType(Object value, Class<?> fieldTypeClass) {    
        Object retVal = null; 
        if(Long.class.getName().equals(fieldTypeClass.getName())    
                || long.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Long.parseLong(value.toString());    
        } else if(Integer.class.getName().equals(fieldTypeClass.getName())    
                || int.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Integer.parseInt(value.toString());    
        } else if(Float.class.getName().equals(fieldTypeClass.getName())    
                || float.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Float.parseFloat(value.toString());    
        } else if(Double.class.getName().equals(fieldTypeClass.getName())    
                || double.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Double.parseDouble(value.toString()); 
        } else if(Boolean.class.getName().equals(fieldTypeClass.getName())    
                || boolean.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Boolean.parseBoolean(value.toString());
        } else if(Date.class.getName().equals(fieldTypeClass.getName())    
                || Date.class.getName().equals(fieldTypeClass.getName())) {
        	Calendar ca = Calendar.getInstance();
        	ca.setTime(new Date((Long)value));
        	Date date = ca.getTime();
            retVal = date; 
        } else {    
            retVal = String.valueOf(value);    
        }    
        return retVal;    
    }
    
	 /**  
     * 将Bean对象通过反射机制转换成map对象 
     * @param obj 待转换的class  
     * @return 转换后的Map对象  
     * @throws Exception 异常  
     */  
    public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null){    
            return null;    
        }   
  
        Map<String, Object> map = new HashMap<String, Object>();    
  
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);  
            map.put(field.getName(), field.get(obj));  
        }    
        return map;  
    }   
}
