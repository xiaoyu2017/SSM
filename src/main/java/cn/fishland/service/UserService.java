package cn.fishland.service;

import cn.fishland.domain.pojo.User;

import java.util.List;

/**
 * 用户服务类接口
 *
 * @author xiaoyu
 * @version 1.0
 */
public interface UserService {

    boolean save(User user);

    boolean delete(int id);

    boolean update(User user);

    User getUserById(int id);

    List<User> getUserAll();
}
