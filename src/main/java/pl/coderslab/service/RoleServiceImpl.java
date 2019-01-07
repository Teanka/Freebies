package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Role;
import pl.coderslab.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements  RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByRole(name);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
