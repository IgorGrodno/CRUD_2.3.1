package web.services;

import web.models.User;

import java.util.List;

public interface UserService{
    void add(User user);
    List<User> listUsers();
    void delete(long id);
    void edit(User user);

    User getUser(long id);
}
