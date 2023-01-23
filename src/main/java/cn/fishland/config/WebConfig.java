package cn.fishland.config;

import cn.fishland.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * SpringMVC属性配置类。
 * <p>
 * 继承WebMvcConfigurationSupport类根据方法传功能实现类即可。
 *
 * @author xiaoyu
 * @version 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 静态资源过滤。
     *
     * @param registry SpringMVC提供。
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 第一个参数为请求Url，第二个表示为本地资源文件夹路径。
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /** 自定义拦截器 */
    @Autowired
    UserInterceptor userInterceptor;

    /**
     * 添加拦截器。
     *
     * @param registry SpringMVC提供。
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，拦截的url
        registry.addInterceptor(userInterceptor).addPathPatterns("/user", "/user/*");
    }
}
