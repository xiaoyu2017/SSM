package cn.fishland.exception;

/**
 * 自定义系统异常，此异常表示对外友好提示，对内快速通知。
 *
 * @author xiaoyu
 * @version 1.0
 */
public class SysException extends RuntimeException{
    private Integer code;

    public SysException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public SysException(String message, Throwable cause, Integer code) {
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
