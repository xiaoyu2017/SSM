package cn.fishland.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源配置类。
 * <p>
 * 此类需要Spring容器进行管理。
 *
 * @author xiaoyu
 * @version 1.0
 */
public class JdbcConfig {

    /** 数据库驱动 */
    @Value("${jdbc.driver}")
    private String driver;

    /** 数据库连接url */
    @Value("${jdbc.url}")
    private String url;

    /** 用户名 */
    @Value("${jdbc.username}")
    private String username;

    /** 用户密码 */
    @Value("${jdbc.password}")
    private String password;

    /**
     * 使用druid数据库连接池配置数据源
     * <p>
     * `@Bean`：将返回对象加入容器中
     *
     * @return 数据源
     */
    @Bean
    public DataSource dataSource() {
        // 创建druid数据源
        DruidDataSource dataSource = new DruidDataSource();
        // 设置数据源基础数据
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // ... 还可以详细的进行数据库连接池，根据自己需求
        return dataSource;
    }

    /**
     * 配置事务管理器
     * PlatformTransactionManager：事务管理接口。
     * DataSourceTransactionManager：事务管理接口实现类，基于jdbc实现事务管理。
     *
     * @param dataSource 数据源，自动注入。
     * @return 事务管理具体实现类，根据ORM数据库框架，这里使用的是Mybatis，所以返回的是DataSourceTransactionManager对象
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
