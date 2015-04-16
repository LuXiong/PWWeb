package com.pwweb.service;

import java.util.List;

import com.pwweb.model.User;

public interface UserService {

	public void saveUser(User user);      //�����û�  
    public User queryByUsername(String username);    //�����û��������û�  
    public void deleteUser(User user);              //ɾ���û�
    public void updateUser(User user);              //�޸��û�����
    public List<User> findAllUser();
}
