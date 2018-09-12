package cn.tedu.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tedu.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable>{

}
