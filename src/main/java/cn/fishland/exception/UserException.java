package cn.fishland.exception;

/**
 * 自定义系统异常，此异常表示对外详细提示，对内也通知。
 *
 * @author xiaoyu
 * @version 1.0
 */
public class UserException extends RuntimeException{
    private Integer code;

    public UserException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public UserException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SysException{" +
                "code=" + code +
                "} " + super.toString();
    }
}
