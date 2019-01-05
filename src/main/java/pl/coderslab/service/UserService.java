package pl.coderslab.service;

import pl.coderslab.entity.User;

public interface UserService {

     User findByEmail(String email);

     User findByUsername(String username);
}
