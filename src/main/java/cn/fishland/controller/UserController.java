package cn.fishland.controller;

import cn.fishland.domain.pojo.User;
import cn.fishland.domain.vo.RequestCode;
import cn.fishland.domain.vo.RequestResult;
import cn.fishland.exception.SysException;
import cn.fishland.exception.UserException;
import cn.fishland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户前端控制类
 *
 * @author xiaoyu
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 保存user。
     * <p>
     * `@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")`：格式化传递的参数日期格式。
     * <p>
     * `@RequestBody`：格式化JSON参数，JSON to object。
     *
     * @param user
     * @return
     */
    @PostMapping
    public RequestResult save(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestBody User user) {
        if (user == null || StringUtils.isEmpty(user.getName())) {
            throw new UserException("用户名不能为空", RequestCode.PARAM_ERROR);
        }
        if (userService.save(user)) {
            return new RequestResult(user, RequestCode.SAVE_SUCCESS, "save success");
        } else {
            throw new SysException("保存出错，请稍后重试", RequestCode.SAVE_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public RequestResult deleteUserById(@PathVariable("id") int id) {
        if (userService.delete(id)) {
            return new RequestResult(RequestCode.DELETE_SUCCESS, "delete success");
        } else {
            throw new SysException("删除出错，请稍后重试", RequestCode.DELETE_ERROR);
        }
    }

    @PutMapping
    public RequestResult update(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestBody User user) {
        if (user == null || StringUtils.isEmpty(user.getId())) {
            throw new UserException("用户名id不能为空", RequestCode.PARAM_ERROR);
        }
        if (userService.update(user)) {
            return new RequestResult(RequestCode.UPDATE_SUCCESS, "update success");
        } else {
            throw new SysException("修改出错，请稍后重试", RequestCode.UPDATE_ERROR);
        }
    }

    @GetMapping
    public RequestResult getAll() {
        List<User> userAll = userService.getUserAll();
        if (userAll != null && userAll.size() > 0) {
            return new RequestResult(userAll, RequestCode.GET_SUCCESS, "get success");
        } else {
            throw new SysException("查询出错，请稍后重试", RequestCode.GET_ERROR);
        }
    }

    @GetMapping("/{id}")
    public RequestResult getById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user != null && user.getId() != null) {
            return new RequestResult(user, RequestCode.GET_SUCCESS, "get success");
        } else {
            throw new SysException("查询出错，请稍后重试", RequestCode.GET_ERROR);
        }
    }
}
