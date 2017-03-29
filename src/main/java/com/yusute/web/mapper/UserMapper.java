package com.yusute.web.mapper;

import com.yusute.web.mapper.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yusutehot on 3/29/2017.
 */
public interface UserMapper {

    @Select(value = "select username,password,enabled from users where username = #{username}")
    User loadUserByUsername(@Param("username") String username);

    @Insert(value = "insert into users (username, password, enabled, create_date) value(#{username},#{password},#{enabled},#{createDate})")
    void saveUser(User user);
}
