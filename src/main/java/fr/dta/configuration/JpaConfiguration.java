package fr.dta.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:application.properties")
public class JpaConfiguration {

	@Autowired
	private Environment environment;

	/* @Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

		return dataSource;
	} */

	/* @Bean
	public PlatformTransactionManager txManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	} */
	
	/* @Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	  LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	  emf.setDataSource(dataSource());
	  emf.setPackagesToScan(new String[] { "fr.dta" });

	  JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	  emf.setJpaVendorAdapter(vendorAdapter);
	  emf.setJpaProperties(additionalProperties());

	  return emf;
	} */
	
	/* Properties additionalProperties() {
	  Properties properties = new Properties();
	  properties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
	  properties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	  properties.setProperty("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	  properties.setProperty("hibernate.use_second_level_cache", environment.getRequiredProperty("hibernate.use_second_level_cache"));
	  return properties;
	} */
	
	/* @Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	} */
}
