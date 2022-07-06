package com.dxc.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.dxc.dao.AccountDAO;
import com.dxc.dao.CustomerDAO;
import com.dxc.dao.ItemDAO;
import com.dxc.dao.impl.AccountDAOImpl;
import com.dxc.dao.impl.CustomerDAOImpl;
import com.dxc.dao.impl.ItemDAOImpl;
import com.dxc.service.CustomerService;
import com.dxc.service.ItemService;
import com.dxc.service.impl.CustomerServiceImpl;
import com.dxc.service.impl.ItemServiceImpl;

@Configuration
@ComponentScan("com.dxc.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {



   // Lưu trữ các giá thuộc tính load bởi @PropertySource.
   @Autowired
   private Environment env;


   @Bean(name = "viewResolver")
   public InternalResourceViewResolver getViewResolver() {
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       viewResolver.setPrefix("/WEB-INF/pages/");
       viewResolver.setSuffix(".jsp");
       return viewResolver;
   }
   
 
   // Cấu hình để Upload.
   @Bean(name = "multipartResolver")
   public CommonsMultipartResolver multipartResolver() {
       CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
       
       // Set Max Size...
       // commonsMultipartResolver.setMaxUploadSize(...);
       
       return commonsMultipartResolver;
   }

   @Bean(name = "dataSource")
   public DataSource getDataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();

 
       // Xem: ds-hibernate-cfg.properties
       dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
       dataSource.setUrl(env.getProperty("ds.url"));
       dataSource.setUsername(env.getProperty("ds.username"));
       dataSource.setPassword(env.getProperty("ds.password"));
       
       System.out.println("## getDataSource: " + dataSource);
       
       return dataSource;
   }

   @Autowired
   @Bean(name = "sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
       Properties properties = new Properties();

 
       // Xem: ds-hibernate-cfg.properties
       properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
       properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
       properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
       properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
       properties.put("hibernate.connection.CharSet", env.getProperty("hibernate.connection.CharSet"));
       properties.put("hibernate.connection.characterEncoding", env.getProperty("hibernate.connection.characterEncoding"));
       properties.put("hibernate.connection.useUnicode", env.getProperty("hibernate.connection.useUnicode"));
       
       LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 
       // Package chứa các entity class.
       factoryBean.setPackagesToScan(new String[] { "com.dxc.entity" });
       factoryBean.setDataSource(dataSource);
       factoryBean.setHibernateProperties(properties);
       factoryBean.afterPropertiesSet();
       //
       SessionFactory sf = factoryBean.getObject();
       System.out.println("## getSessionFactory: " + sf);
       return sf;
   }
   
   @Bean
   public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
      // Load property in message/validator.properties
      rb.setBasenames(new String[] { "messages/validator"});
      rb.setDefaultEncoding("UTF-8");
      return rb;
   }

   @Autowired
   @Bean(name = "transactionManager")
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
       return transactionManager;
   }
   
   @Autowired
   @Bean(name= "hibernateTemplate")
   @Resource(name = "sessionFactory")
   public HibernateTemplate geTemplate(SessionFactory sessionFactory) {
	   HibernateTemplate template = new HibernateTemplate(sessionFactory);
	   return template;
   }
   
   @Bean
   public JdbcTemplate jdbcTemplate() {
	   JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	   return jdbcTemplate;
   }
   
   @Bean(name = "accountDAO")
   public AccountDAO getApplicantDAO() {
       return new AccountDAOImpl();
   }
   
   @Bean(name = "itemDAO")
   public ItemDAO getAppItemDAO() {
	   return new ItemDAOImpl();
   }
   

  @Bean(name = "CustomerDao")
  public CustomerDAO getAppCustomerDao() {
	  return new CustomerDAOImpl();
  }
  
  @Bean(name ="itemService")
  public ItemService getitemService() {
	  return new ItemServiceImpl();
  }
  
  @Bean
  public CustomerService customerService() {
	  return new CustomerServiceImpl();
  }
  
//
//   @Bean(name = "orderDAO")
//   public OrderDAO getOrderDAO() {
//       return new OrderDAOImpl();
//   }
//   
//   @Bean(name = "accountDAO")
//   public AccountDAO getAccountDAO()  {
//       return new AccountDAOImpl();
//   }

}

