package cn.fishland.dao;

import cn.fishland.domain.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 基于Mybatis框架实现数据库操作。
 * <p>
 * 用户数据库操作类。
 *
 * @author xiaoyu
 * @version 1.0
 */
public interface UserDao {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO user (name, age, email, birthday) VALUES(#{name}, #{age}, #{email}, #{birthday})")
    int insert(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int delete(@Param("id") int id);

    @Update("UPDATE user SET name = #{name}, age = #{age}, email = #{email}, birthday = #{birthday} WHERE id = #{id}")
    int update(User user);

    @Select("SELECT id, name, age, email, birthday FROM user WHERE id = #{id}")
    User selectById(@Param("id") int id);

    @Select("SELECT id, name, age, email, birthday FROM user")
    List<User> selectAll();
}
