package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface userdao {
  void addUser(User user);
  User getUser(int UserId);
  void updateUser(User user);
  void deleteUser(int userid);
  List<User> getAllUser();
User getUserByUsername(String username);
}
