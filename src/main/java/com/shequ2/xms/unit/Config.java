package com.shequ2.xms.unit;

import java.util.Properties;

/**
 * 
 * Project:shiro-test
 * Package:com.shequ2.xms.unit
 * FileName:Config.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月6日 上午10:11:01
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description: 配置文件解析类
 * Version:
 */
public class Config {
	public static String platform = "test";
	public static boolean test = true;
	
	private static final String resource = "common.properties";
	private static final Properties props = PropertiesUtil.get(resource, "utf-8");
	
	
	public static String getProperty(String name, String defValue) {
		return props.getProperty(name, defValue);
	}
	
	public static String getProperty(String name) {
		return props.getProperty(name);
	}
	
	static {
		String platform_temp = props.getProperty("platform");
		
		if(!"test".equals(platform_temp)) {
			int dash = platform_temp.indexOf('_');
			if(dash>0) {
				platform = platform_temp.substring(0, dash);
			}else {
				platform = platform_temp;
			}
			test = platform_temp.endsWith("test");
			
			String platformResource = "ginkgo_"+platform_temp+".properties";
			Properties load_temp = PropertiesUtil.load(platformResource, "utf-8");
			if(load_temp!=null) {
				//因为props被修改，所以需要重新读取配置内容、合并、计算配置变量
				Properties load = PropertiesUtil.load(resource, "utf-8");
				props.clear();
				props.putAll(load);
				props.putAll(load_temp);
				PropertiesUtil.extractPropertyValues(props);
			}
		}
	}
}
