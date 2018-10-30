package com.rentvalley.service.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.rentvalley.dao.account"})
public class RVPersistenceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() throws NamingException {
		JndiDataSourceLookup dataSourceLookup=null;
		DataSource dataSource=null;
		dataSourceLookup=new JndiDataSourceLookup();
		dataSource=(DataSource) dataSourceLookup.getDataSource(env.getProperty("rentvalley.jndiName"));
		return dataSource;
	}
	
		@Bean
	    public PlatformTransactionManager platformTransactionManager() {
	        return new JtaTransactionManager();
	    }
		
		@Bean(autowire=Autowire.BY_TYPE)
		public JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate();
		}

}
