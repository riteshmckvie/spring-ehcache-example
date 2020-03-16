package com.techprimers.cache.cache;

import com.techprimers.cache.model.Users;
import com.techprimers.cache.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UsersCache {

    @Autowired
    UsersRepository usersRepository;

    @Cacheable(value = "usersCache", key = "#name")
    public Users getUser(String name) {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByName(name);
    }
    
    @CachePut(value = "usersCache", key = "#name")
    public Users updateUser(String name) {
        System.out.println("Retrieving from Database for name: " + name);
        Users user = usersRepository.findByName(name);
        user.setTeamName("infy");
        return usersRepository.save(user);
    }
}
