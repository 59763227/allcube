package com.gl.allcube.cube.common.datasource;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceFactory {
	public DataSource getDruidDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setUsername("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/cube?useUnicode=true&characterEncoding=UTF-8");
		ds.setPassword("root");
		
		return ds;
	}
}
