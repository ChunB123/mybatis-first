package cn.itheima.mybatis.mapper;

import java.util.List;

import cn.itheima.mybatis.po.User;

public interface UserMapper {

	User getUserById(int id);
	List<User> getUserByName(String username);
	void insertUser(User user);
}
