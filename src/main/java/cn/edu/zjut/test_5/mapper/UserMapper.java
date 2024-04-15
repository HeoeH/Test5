package cn.edu.zjut.test_5.mapper;

import cn.edu.zjut.test_5.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password}) ")
    Integer insert(String username,String password);

    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username, String password);
}
