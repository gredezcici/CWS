package com.cactus.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.cactus.entities.User;

@Mapper
public interface UserMapper {
	@Insert("insert into users(fullname,wechat_account) values(#{name},#{email})")
	@SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = Integer.class)
	void insertUser(User user);

	@Select("select id, fullname,wechat_account from users WHERE id=#{id}")
	User findUser(String id);

	@Select("select id, fullname,wechat_account from users")
	List<User> findAllUsers();
}
