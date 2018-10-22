package com.spring.emma.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //es para trabajar  una interfaz , que puede tener muchos comportamientos
@EnableTransactionManagement //nos ayuda en la parte de transacciones en BD
public class DataBaseConfiguration {
	
	@Bean // nos va a decir el comportamiento tiene el objeto  y contra que clase se va a  instanciar
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.spring.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}
	//esto va a configurar nuestra  conexion a base de datos
	@Bean
	public DataSource dataSource()
	{
		// manejo la persistencia de los datos  con anotaciones
		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernateTabla");
		dataSource.setUsername("Eche200");
		dataSource.setPassword("Biologia1");
		
		return dataSource;
		
	}
	
	//trabajamos ahora en un metodo de propiedades, le dejamos el dialecto y si quieor que se muestre el SQL
	public Properties hibernateProperties()
	{
		Properties properties =  new Properties ();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("show_sql", "true");
		
		return properties;
		
	}
	
	//ahora trabajamos con la aprte de las transacciones
	@Bean
	@Autowired
	public HibernateTransactionManager  transactionManager()
	{
		HibernateTransactionManager hibernateTransaction = new HibernateTransactionManager();
		hibernateTransaction.setSessionFactory(sessionFactory().getObject());
		return hibernateTransaction;
		
	}

}
