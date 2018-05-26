package net.kzn.shoppingbackend.config;

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
@ComponentScan(basePackages = {"net.kzn.shoppingbackend.dto"})
@EnableTransactionManagement
public class hibernateConfig {

	/* change the below the dbms that you use */
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	


	/* data source bean will availabka */
	@Bean
	public DataSource getDataSourse() {
		BasicDataSource datasourse = new BasicDataSource();

		/* providing connection information */
		datasourse.setDriverClassName(DATABASE_DRIVER);
		datasourse.setUrl(DATABASE_URL);
		datasourse.setUsername(DATABASE_USERNAME);
		datasourse.setPassword(DATABASE_PASSWORD);

		return datasourse;
	}
	/* session factory bean will availabla */

	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.kzn.shoppingbackend.dto");

		return builder.buildSessionFactory();
	}

	/* all the hibernate properties will be returned in this method */

	
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		//properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;

	}

	/* transactionmanager bean */
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory) {

		HibernateTransactionManager transactionmanager = new HibernateTransactionManager(sessionfactory);

		return transactionmanager;
	}
}
