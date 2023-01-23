package cn.fishland.advice;

import cn.fishland.domain.vo.RequestCode;
import cn.fishland.domain.vo.RequestResult;
import cn.fishland.exception.SysException;
import cn.fishland.exception.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理通知类。
 * <p>
 * 此类需要被Spring扫描并管理。
 * <p>
 * `@RestControllerAdvice`：表示这是一个Rest风格的Controller通知类
 *
 * @author xiaoyu
 * @version 1.0
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 拦截位置的所有异常。
     * <p>
     * `@ExceptionHandler(Exception.class)`：表示这一个桶通知，参数表示此通知应用在哪个异常上，包括其子类。
     *
     * @param e 异常对象
     * @return 友好的统一返回对象
     */
    @ExceptionHandler(Exception.class)
    public RequestResult exceptionAdvice(Exception e) {
        // 调试可以打开，便于异常快速处理
        // e.printStackTrace();

        // 短信或邮件通知维护人员
        // 短信或邮件通知开发人员
        return new RequestResult(RequestCode.SYS_ERROR, "系统出现问题，请稍后再试");
    }

    /**
     * 针对SysException异常的通知
     *
     * @param e 异常对象
     * @return 友好的统一返回对象
     */
    @ExceptionHandler(SysException.class)
    public RequestResult sysExceptionAdvice(SysException e) {
        // 短信或邮件通知维护人员
        // 短信或邮件通知开发人员
        return new RequestResult(e.getCode(), e.getMessage());
    }

    /**
     * 针对UserException异常的通知
     *
     * @param e 异常对象
     * @return 友好的统一返回对象
     */
    @ExceptionHandler(UserException.class)
    public RequestResult userExceptionAdvice(UserException e) {
        // 短信或邮件通知维护人员
        // 短信或邮件通知开发人员
        return new RequestResult(e.getCode(), e.getMessage());
    }
}
