package cn.fishland.domain.vo;

import java.util.Date;

/**
 * 统一的返回结果类
 *
 * @author xiaoyu
 * @version 1.0
 */
public class RequestResult {

    private Object data;
    private Integer code;
    private String msg;
    private Date time;

    public RequestResult() {
        time = new Date();
    }

    public RequestResult(Object data, Integer code, String msg) {
        this();
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public RequestResult(Integer code, String msg) {
        this(null, code, msg);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", time=" + time +
                '}';
    }
}
