package cn.fishland.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * SpringMvc配置类。
 * <p>
 * `@EnableWebMvc`：基础配置，JSON格式转换等。
 *
 * @author xiaoyu
 * @version 1.0
 */
@EnableWebMvc
@Configuration
@ComponentScan({"cn.fishland.controller", "cn.fishland.config"})
@Import({ServletConfig.class})
public class SpringMvcConfig {
}
