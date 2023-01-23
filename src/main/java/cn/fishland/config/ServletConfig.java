package cn.fishland.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Servlet配置类，替代web.xml文件，此类由SpringMVC配置类管理。
 * <p>
 * 继承AbstractAnnotationConfigDispatcherServletInitializer类，通过注解配置类。
 *
 * @author xiaoyu
 * @version 1.0
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 加载Spring配置类。
     *
     * @return 配置类数组，通常也就一个类。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 加载SpringMVC配置类。
     *
     * @return 配置类数组。
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 配置哪些请求url被SpringMVC接管，一般会配置全部。
     *
     * @return url通配符数组
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 过滤器配置，SpringMVC过滤器很多，都可以再次配置。
     *
     * @return 过滤器数组
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
