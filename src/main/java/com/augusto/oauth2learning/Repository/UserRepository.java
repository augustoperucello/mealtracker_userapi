package com.augusto.oauth2learning.Repository;

import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public Optional<User> findByFacebookId(Long facebookId){
        //Creating an empty optional to use as return type;
        User User = find("facebookId", facebookId).firstResult();
        Optional<User> userOptional = Optional.of(User);
        return userOptional;
    };
    public Optional<User> findByFirstName(String firstName)
    {
        //Creating an empty optional to use as return type;
        User User = find("firstName", firstName).firstResult();
        Optional<User> userOptional = Optional.of(User);
        return userOptional;
    };
    public void deleteById(Long id) throws ResourceNotFoundException{
        User user = findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ id));
        delete(user);};
    public List<User> findAllUsers(){
        List<User> users = this.listAll();
        return users;
    }
}
