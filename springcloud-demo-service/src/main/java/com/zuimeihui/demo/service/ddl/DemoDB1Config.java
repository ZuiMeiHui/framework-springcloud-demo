package com.zuimeihui.demo.service.ddl;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * db_demo_1库 - 数据库配置
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 11:17:35
 */
@Configuration
@MapperScan(basePackages = { "com.zuimeihui.demo.service.dao.db1", "com.zuimeihui.demo.service.dao.db1.*" }, sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DemoDB1Config {

	@Primary 
	@Bean("db1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource getDb1DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean("db1SqlSessionFactory")
	public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db1/*.xml"));
		return bean.getObject();
	}

	@Primary
	@Bean("db1SqlSessionTemplate")
	public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
