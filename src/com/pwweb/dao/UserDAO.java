package com.pwweb.dao;

import java.util.List;

import com.pwweb.model.User;

public interface UserDAO {

	public void saveUser(User user);      //保存用户  
    public User queryByUsername(String username);    //根据用户名查找用户  
    public void deleteUser(User user);              //删除用户
    public void updateUser(User user);              //修改用户资料
    public List<User> findAllUser();
}
