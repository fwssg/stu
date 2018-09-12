package cn.tedu.service;

import java.util.List;

import cn.tedu.model.User;

public interface UserService {
	public List<User> find();
	public User get(Integer id);
}
