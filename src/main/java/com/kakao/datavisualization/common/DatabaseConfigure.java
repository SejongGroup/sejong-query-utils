package com.kakao.datavisualization.common;

import java.io.InputStream;
import java.io.Reader;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import org.mybatis.spring.SqlSessionTemplate;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



public class DatabaseConfigure {
	
    private static final int INITIALIZE_POOL_SIZE = 10;
    private static final int MAX_CONNECTION_POOL_SIZE = 10;
    private static final int MAX_IDLE_POOL_SIZE = 10;
    private static final long MAX_CONNECTION_WAIT_MS = 30000L;

    public static BasicDataSource dbcpDataSource(String databaseurl, String databaseid, String databasepw) {
        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setDriverClassName("oracle.jdbc.OracleDriver");
        dbcp.setUrl(databaseurl);
        dbcp.setUsername(databaseid);
        dbcp.setPassword(databasepw);

        dbcp.setInitialSize(INITIALIZE_POOL_SIZE);
        dbcp.setMaxIdle(MAX_IDLE_POOL_SIZE);
        dbcp.setTestWhileIdle(true);
        dbcp.setValidationQuery("SELECT 1 FROM DUAL");
        dbcp.setPoolPreparedStatements(true);

        return dbcp;
    }

	  public static SqlSession sqlSessionTemplate(String databaseurl, String databaseid, String databasepw) {
		  
		  SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(dbcpConfiguration(databaseurl, databaseid, databasepw));
		  factory.getConfiguration();
	      return factory.openSession();
	  }
	  
	  private static Configuration dbcpConfiguration(String databaseurl, String databaseid, String databasepw){
		  DataSource dataSource = dbcpDataSource(databaseurl, databaseid, databasepw);
		  
		  
		  TransactionFactory trxFactory = new JdbcTransactionFactory();
		  Environment env = new Environment("env",trxFactory, dataSource);

		  InputStream inputStream = DatabaseConfigure.class.getClassLoader().getResourceAsStream("config/commandmapper.xml");
		  XMLConfigBuilder parser = new XMLConfigBuilder(inputStream);
		  Configuration config = parser.parse();
		  config.setEnvironment(env);

		  return config;
	  }
	  
}
