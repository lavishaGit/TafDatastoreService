package com.tfa.datastore.Service.Interfaces;


import com.tfa.datastore.Models.Users;
import com.tfa.datastore.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {


    public Users saveUser(Users user);


    public  Users getUserById(Long id) throws Exception;

    public Users updateUser(Long id, Users updatedUser);
}
