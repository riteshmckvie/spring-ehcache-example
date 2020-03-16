package com.techprimers.cache.resource;

import com.techprimers.cache.cache.UsersCache;
import com.techprimers.cache.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    UsersCache usersCache;

    @GetMapping(value = "/{name}")
    public Users getUser(@PathVariable String name) {
        return usersCache.getUser(name);
    }
    
    @PutMapping(value = "/{name}")
    public Users updateUserById(@PathVariable String name) {
        return usersCache.updateUser(name);
    }
}
