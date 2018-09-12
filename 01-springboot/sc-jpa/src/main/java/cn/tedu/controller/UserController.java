package cn.tedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.dao.UserRepository;
import cn.tedu.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository UserRepository;

	@RequestMapping("/queryAll")
	//@ResponseBody
	public List<User> queryAll(){
        List<User> list = new ArrayList<User>();
        list = UserRepository.findAll();
        return list;
    }
}
