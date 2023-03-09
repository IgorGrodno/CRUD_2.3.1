package web.service;

import web.dao.UserDao;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }
    @Override
    @Transactional
    public void edit(User user, Long id) {
        userDao.edit(user, id);
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}
