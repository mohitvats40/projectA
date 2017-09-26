package com.niit.Back.confeg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.niit.Back.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/electromart";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
     
	//databse connection
	@Bean
	public DataSource getDataSource(){
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		//datasource.setDriverClassName(DATABASE_DIALECT);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		return datasource;
		
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource){
		LocalSessionFactoryBuilder sessionbuilder=new LocalSessionFactoryBuilder(datasource);
		 sessionbuilder.addProperties(getHibernateProperties());
		sessionbuilder.scanPackages("com.niit.Back.dto");
		return sessionbuilder.buildSessionFactory();
		
	}
	
	//all the hibernate properties

	private Properties getHibernateProperties() {
		
		Properties properties= new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManagement(SessionFactory sessionfactory){
		HibernateTransactionManager transactionmanager=new HibernateTransactionManager(sessionfactory);
		return transactionmanager;
	}
	
	
	
}