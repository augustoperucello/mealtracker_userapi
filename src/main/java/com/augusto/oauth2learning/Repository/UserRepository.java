package com.augusto.oauth2learning.Repository;

import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public Optional<User> findByFacebookId(Long facebookId){
        return findByFacebookId(facebookId);
    };
    public Optional<User> findByFirstName(String firstName)
    {
        return findByFirstName(firstName);
    };
    public void deleteById(Long id) throws ResourceNotFoundException{
        User user = findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ id));
        delete(user);};
    public List<User> findAllUsers(){
        List<User> users = this.listAll();
        return users;
    }
}
