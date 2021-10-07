package com.lagou.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyDataSourceAutoConfiguration {

	Logger logger = LoggerFactory.getLogger(MyDataSourceAutoConfiguration.class);

	/**
	 * 	master dataSource
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.druid.datasource.master")
	public DataSource masterDataSource(){
		logger.info("create master dataSource...");
		return DataSourceBuilder.create().build();
	}

	/**
	 * 	slave dataSource
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.druid.datasource.slave")
	public DataSource slaveDataSource(){
		logger.info("create slave dataSource...");
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public DataSource primaryDataSource(
			@Autowired @Qualifier("masterDataSource") DataSource masterDataSource,
			@Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource
	){

		RoutingDataSource routingDataSource = new RoutingDataSource();
		Map<Object, Object> map = new HashMap<>();
		map.put("master",masterDataSource);
		map.put("slave",slaveDataSource);

		routingDataSource.setTargetDataSources(map);

		return routingDataSource;

	}



}
