package org.mateuszsikorski.wirtualnydziekanat.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.mateuszsikorski.wirtualnydziekanat.*")
@EnableTransactionManagement
public class Config extends WebMvcConfigurerAdapter{
	
	private final String dbUrl = "jdbc:mysql://localhost:3306/dziennikmobilny?useSSL=false";
	private final String dbUser = "springstudent";
	private final String dbPass = "springstudent";
	/*
	private final String dbUrl = "jdbc:mysql://localhost:3306/dziennikmobilny?useSSL=false";
	private final String dbUser = "springstudent";
	private final String dbPass = "springstudent";
	*/

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);

		return viewResolver;
	}

	@Bean(name = "dataSource")
	public ComboPooledDataSource myDataSource() {

		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		try {
			myDataSource.setDriverClass("com.mysql.jdbc.Driver");
			myDataSource.setJdbcUrl(dbUrl);
			myDataSource.setUser(dbUser);
			myDataSource.setPassword(dbPass);

			// setting up connection pool
			myDataSource.setMinPoolSize(5);
			myDataSource.setMaxPoolSize(20);
			myDataSource.setMaxIdleTime(30000);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		return myDataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory mySessionFactory(ComboPooledDataSource myDataSource) throws IOException {

		LocalSessionFactoryBean mySessionFactory = new LocalSessionFactoryBean();
		
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		properties.put("hibernate.show_sql", true);
		
		mySessionFactory.setDataSource(myDataSource);
		mySessionFactory.setPackagesToScan("org.mateuszsikorski.wirtualnydziekanat.entity");
		mySessionFactory.setHibernateProperties(properties);
		mySessionFactory.afterPropertiesSet(); // kurestwo!!!
		
		return mySessionFactory.getObject();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager myTransactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager myTransactionManager = new HibernateTransactionManager();
		
		myTransactionManager.setSessionFactory(sessionFactory);
		
		return myTransactionManager;
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
