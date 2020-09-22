package com.augusto.oauth2learning.Repository;

import com.augusto.oauth2learning.Entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public Optional<User> findByFacebookId(Long facebookId){
        //Creating an empty optional to use as return type;
        User User = find("facebookId", facebookId).firstResult();
        Optional<User> userOptional = Optional.ofNullable(User);
        return userOptional;
    };
    public Optional<User> findByFirstName(String firstName)
    {
        //Creating an empty optional to use as return type;
        User User = find("firstName", firstName).firstResult();
        Optional<User> userOptional = Optional.ofNullable(User);
        return userOptional;
    };
    public List<User> findAllUsers(){
        List<User> users = this.listAll();
        return users;
    }
}
