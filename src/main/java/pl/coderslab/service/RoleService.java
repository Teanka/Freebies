package pl.coderslab.service;

import pl.coderslab.entity.Role;

public interface RoleService {

    Role findByName (String name);

    void saveRole (Role role);
}
