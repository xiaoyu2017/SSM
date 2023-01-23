package cn.fishland.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * user相关请求拦截器。此类需要Spring容器管理。
 * <p>
 * 实现HandlerInterceptor接口的三个方法即可。
 *
 * @author xiaoyu
 * @version 1.0
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 方法(Controller的方法)执行前执行。
     *
     * @param request  请求对象
     * @param response 返回对象
     * @param handler  Controller方法对象（HandlerMethod）
     * @return true继续执行，false直接调到afterCompletion方法。
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(((HandlerMethod) handler).getMethod().getName() + "执行前执行...");
        return true;
    }

    /**
     * 方法(Controller的方法)执行成功后执行。
     *
     * @param request      请求对象
     * @param response     返回对象
     * @param handler      Controller方法对象（HandlerMethod）
     * @param modelAndView Controller方法对象（HandlerMethod）返回值。
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(((HandlerMethod) handler).getMethod().getName() + "执行完成后执行，返回参数=" + new ObjectMapper().writeValueAsString(modelAndView));
    }

    /**
     * 方法(Controller的方法)执行后执行。
     *
     * @param request  请求对象
     * @param response 返回对象
     * @param handler  Controller方法对象（HandlerMethod）
     * @param ex       Controller方法对象（HandlerMethod）出现的异常对象
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            System.out.println(((HandlerMethod) handler).getMethod().getName() + "执行后执行, 异常信息：" + ex.getMessage());
        } else {
            System.out.println(((HandlerMethod) handler).getMethod().getName() + "执行后执行");

        }
    }
}
