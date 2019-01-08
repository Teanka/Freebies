package pl.coderslab.service;

import pl.coderslab.entity.User;

import java.util.List;

public interface UserService {

     User findByEmail(String email);

     User findByUsername(String username);

     List<User> findAll ();

     void saveUser(User user);

     void  delete (User user);
}
