package cn.fishland;

import cn.fishland.config.SpringConfig;
import cn.fishland.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 *
 * @author xiaoyu
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class SpringTest {

    @Autowired
    UserDao userDao;

    @Test
    public void userDaoTest() {
        System.out.println(userDao.getClass().getName());
    }

}
