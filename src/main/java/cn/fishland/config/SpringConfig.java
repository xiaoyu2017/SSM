package cn.fishland.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring配置类，代替application.xml配置文件。
 * <p>
 * `@Configuration`:当前为配置类。
 * <p>
 * `@EnableTransactionManagement`：开启事务，同时需要装配事务实现类在JdbcConfig类中。
 * <p>
 * `@PropertySource("classpath:jdbc.properties")`：加载外部资源文件，classpath表示从项目根目录开始。
 * <p>
 * `@Import({JdbcConfig.class, MybatisConfig.class})`：表示把特定功能配置分开配置，分开管理。
 * <p>
 * `@ComponentScan({"cn.fishland.service", "cn.fishland.advice", "cn.fishland.interceptor"})`：需要扫描的bean包
 *
 * @author xiaoyu
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
@ComponentScan({"cn.fishland.service", "cn.fishland.advice", "cn.fishland.interceptor"})
public class SpringConfig {

}
