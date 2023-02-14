// package com.example.webbanhangfinal.SecurityConfig.DataSourceConfig;

// import java.util.HashMap;

// import javax.sql.DataSource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.core.env.Environment;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;

// import lombok.RequiredArgsConstructor;

// // @Configuration
// @PropertySource({"classpath:WebConfigDB.properties"})
// @EnableJpaRepositories(
//     basePackages = "com.example.webbanhangfinal",
//     entityManagerFactoryRef = "WebEntityManager",
//     transactionManagerRef = "WebTransactionManager"

    
// )
// @RequiredArgsConstructor
// public class PersistenceWebConfig {
//     private final Environment env;
   
    
//     @Bean
//     public LocalContainerEntityManagerFactoryBean WebEntityManager(){
//         LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//         entityManager.setDataSource(WebDataSource());
//         entityManager.setPackagesToScan(new String[] {"com.example.webbanhangfinal"});
//         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//         entityManager.setJpaVendorAdapter(vendorAdapter);
//         HashMap<String,Object> properties= new HashMap<>();
//         properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//         properties.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
//         entityManager.setJpaPropertyMap(properties);
//         return entityManager;
//     }
// @Bean
//     private DataSource WebDataSource() {
//         DriverManagerDataSource dataSource = new DriverManagerDataSource();
//         dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//         dataSource.setUrl(env.getProperty("web.jdbc.url"));
//         dataSource.setUsername(env.getProperty("jdbc.user"));
//         dataSource.setPassword(env.getProperty("jdbc.pass"));
       
//         return dataSource;
//     }
// @Bean
// public PlatformTransactionManager WebTransactionManager(){
//     JpaTransactionManager transactionManager=
//                     new JpaTransactionManager();
//     transactionManager.setEntityManagerFactory(WebEntityManager().getObject());
//     return transactionManager;
// }
// }
