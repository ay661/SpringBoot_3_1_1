package ay.spring.springboot_3_1_1.service;

import ay.spring.springboot_3_1_1.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    User getUserId(long id);

    User removeUser(long id);

}