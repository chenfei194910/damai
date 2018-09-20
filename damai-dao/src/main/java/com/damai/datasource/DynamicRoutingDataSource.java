package com.damai.datasource;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * 
 * @author felix.chen
 * @date 2018年2月12日 上午15:26:57
 *
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource{

	private DataSource targetDataSources;
	@Override
    protected Object determineCurrentLookupKey() {

        return DynamicRoutingContextHolder.getRouteStrategy();
    }
}