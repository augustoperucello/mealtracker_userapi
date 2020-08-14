package com.augusto.oauth2learning.Service;

import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Exceptions.CannotSaveResourceException;
import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import com.augusto.oauth2learning.Repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jdk.internal.loader.Resource;
import org.hibernate.ResourceClosedException;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    @Inject
    UserRepository userRepository;

    //Method responsible for updating an User By ID
    //It is not possible to change the ID, but you can use this method to change the facebookId
    public User updateUserById(Long userId, User userDetails) throws ResourceNotFoundException, CannotSaveResourceException {
        User user = userRepository.findByIdOptional(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setUpdatedAt(new Date());
        user.setBirthday();
        user.setFacebookId(userDetails.getFacebookId());
        userRepository.persist(user);
        if(userRepository.isPersistent(user)){
            // delete it
            return user;
        }
        else {
            throw new CannotSaveResourceException("It was not possible to save the user");
        }
    }

    //Method responsible for updating an User By Facebook ID
    //It is not possible to change the ID.
    public User updateUserByFacebookId(Long facebookId, User userDetails) throws ResourceNotFoundException, CannotSaveResourceException {
        User user = userRepository.findByFacebookId(facebookId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + facebookId));
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setUpdatedAt(new Date());
        user.setBirthday();
        userRepository.persist(user);
        if (userRepository.isPersistent(user)) {
            // delete it
            return user;
        }
        else {
            throw new CannotSaveResourceException("It was not possible to save the user");
        }
    }

    public List<User> getAllUsers (){
        return userRepository.findAllUsers();
    }

    public User getUserByFacebookId(Long facebookId) throws ResourceNotFoundException{
        User user = userRepository.findByFacebookId(facebookId).orElseThrow(() -> new ResourceNotFoundException ("user not found on :: " + facebookId));
        return user;
    }

    public User getUserById(Long Id) throws ResourceNotFoundException{
        User user = userRepository.findByIdOptional(Id).orElseThrow(() -> new ResourceNotFoundException ("user not found on :: " + Id));
        return user;
    }

    public User getUserByFirstName(String firstName) throws ResourceNotFoundException{
        User user = userRepository.findByFirstName(firstName).orElseThrow(() -> new ResourceNotFoundException ("user not found on :: " + firstName));
        return user;
    }

    public User createNewUser(User user) throws CannotSaveResourceException {
        userRepository.persist(user);
        if (userRepository.isPersistent(user)) {
            // delete it
            return user;
        }
        else {
            throw new CannotSaveResourceException("It was not possible to save the user");
        }
    }

    public Map<String, Boolean> deleteAnUser(Long userId)throws ResourceNotFoundException{
        User user = userRepository.findByIdOptional(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on ::" + userId));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public Map<String, Boolean> deleteAnUserByFacebookId(Long facebookId) throws ResourceNotFoundException{
        User user = userRepository.findByFacebookId(facebookId).orElseThrow(() -> new ResourceNotFoundException("User not found on ::" + facebookId));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

