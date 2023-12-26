package ay.spring.springboot_3_1_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ay.spring.springboot_3_1_1.dao.UserDao;
import ay.spring.springboot_3_1_1.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements ay.spring.springboot_3_1_1.service.UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserId(long id) {
        return userDao.getUserId(id);
    }

    @Override
    @Transactional
    public User removeUser(long id) {
        return userDao.removeUser(id);
    }
}