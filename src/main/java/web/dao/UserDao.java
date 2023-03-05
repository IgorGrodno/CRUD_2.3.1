package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void delete(User user);
   void edit(User user);
}
