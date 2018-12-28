package pl.coderslab.service;

import pl.coderslab.model.User;

public interface UserService {

    public User findByEmail(String email);

    public User findByUsername(String username);
}
