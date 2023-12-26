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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * db_demo_2库 - 数据库配置
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 11:17:35
 */
@Configuration
@MapperScan(basePackages = { "com.zuimeihui.demo.service.dao.db2", "com.zuimeihui.demo.service.dao.db2.*" }, sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DemoDB2Config {

	@Bean("db2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db2")
	public DataSource getDb2DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("db2SqlSessionFactory")
	public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db2/*.xml"));
		return bean.getObject();
	}

	@Bean("db2SqlSessionTemplate")
	public SqlSessionTemplate db2SqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
