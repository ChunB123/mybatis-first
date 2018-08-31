package cn.itheima.mybatis.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itheima.mybatis.dao.UserDao;
import cn.itheima.mybatis.po.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User getUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 根据id查询用户信息
		User user = sqlSession.selectOne("getUserById", id);
		// 关闭SQLSession
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByName(String username) {
		// 创建一个SQLSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行查询
		List<User> list = sqlSession.selectList("getUserByName", username);
		// 释放资源
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		// 创建一个SQLSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 插入用户
		sqlSession.insert("insertUser", user);
		// 提交事务
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
		
	}

}
