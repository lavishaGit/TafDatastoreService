package com.tfa.datastore.Service;


import com.tfa.datastore.Models.Users;
import com.tfa.datastore.Repositories.UsersRepository;
import com.tfa.datastore.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    public Users getUserById(Long id) throws Exception {
        return usersRepository.findById(id).orElseThrow(() -> new Exception("User not found" + id));
    }

    public Users updateUser(Long id, Users updatedUser) {
        Users user = usersRepository.findById(id).orElseThrow();
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        return usersRepository.save(user);
    }
}