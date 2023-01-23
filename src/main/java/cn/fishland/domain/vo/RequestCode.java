package cn.fishland.domain.vo;

/**
 * 状态码
 *
 * @author xiaoyu
 * @version 1.0
 */
public class RequestCode {
    public static final int SAVE_SUCCESS = 2001;
    public static final int DELETE_SUCCESS = 2002;
    public static final int UPDATE_SUCCESS = 2003;
    public static final int GET_SUCCESS = 2004;
    public static final int SAVE_ERROR = 4001;
    public static final int DELETE_ERROR = 4002;
    public static final int UPDATE_ERROR = 4003;
    public static final int GET_ERROR = 4004;

    public static final int PARAM_ERROR = 40010;

    public static final int SYS_ERROR = 6001;
    public static final int SYS_SAVE_ERROR = 6002;
    public static final int USER_ERROR = 7001;
    public static final int USER_PARAM = 7002;

}
