package cn.fishland.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Mybatis配置类，代替原XML配置文件。
 * <p>
 * 此类由Spring容器管理。
 *
 * @author xiaoyu
 * @version 1.0
 */
public class MybatisConfig {
    /**
     * Mybatis核心工厂类，此类是由Mybatis提供。
     *
     * @param dataSource 数据源
     * @return Mapper类创建工厂SqlSessionFactoryBean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        factoryBean.setDataSource(dataSource);
        // 设置别名
        factoryBean.setTypeAliasesPackage("cn.fishland.domain");
        return factoryBean;
    }

    /**
     * Mybatis的Mapper类扫描配置，此类由Mybatis提供，用于整合Spring。
     *
     * @return Mapper类扫描配置类MapperScannerConfigurer
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // Mapper目标类包名
        mapperScannerConfigurer.setBasePackage("cn.fishland.dao");
        return mapperScannerConfigurer;
    }
}
