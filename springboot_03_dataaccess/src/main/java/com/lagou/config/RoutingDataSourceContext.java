package com.lagou.config;

public class RoutingDataSourceContext {

	static  final ThreadLocal<String> threadLocal = new ThreadLocal<>();

	// key:指定数据源类型 master slave
	public RoutingDataSourceContext(String key) {
		threadLocal.set(key);
	}

	public static String getDataSourceRoutingKey(){
		String key = threadLocal.get();
		return key == null ? "master" : key;
	}

	public void close(){
		threadLocal.remove();
	}



}
