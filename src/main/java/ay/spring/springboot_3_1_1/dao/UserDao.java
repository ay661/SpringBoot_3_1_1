package ay.spring.springboot_3_1_1.dao;

import ay.spring.springboot_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    User getUserId(long id);

    User removeUser(long id);

}