package cn.fishland.service.impl;

import cn.fishland.dao.UserDao;
import cn.fishland.domain.pojo.User;
import cn.fishland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务类实现类
 *
 * @author xiaoyu
 * @version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.insert(user)==1;
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id)==1;
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user)==1;
    }

    @Override
    public User getUserById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getUserAll() {
        return userDao.selectAll();
    }

}
