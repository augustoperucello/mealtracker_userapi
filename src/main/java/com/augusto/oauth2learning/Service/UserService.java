package com.augusto.oauth2learning.Service;

import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import com.augusto.oauth2learning.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Method responsible for updating an User By ID
    //It is not possible to change the ID, but you can use this method to change the facebookId
    public ResponseEntity<User> updateUserById(Long userId, User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setUpdatedAt(new Date());
        user.setBirthday();
        user.setFacebookId(userDetails.getFacebookId());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    //Method responsible for updating an User By Facebook ID
    //It is not possible to change the ID.
    public ResponseEntity<User> updateUserByFacebookId(Long facebookId, User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findByFacebookId(facebookId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ facebookId));
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setUpdatedAt(new Date());
        user.setBirthday();
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    public List<User> getAllUsers() throws ResourceNotFoundException{
        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserByFacebookId(Long facebookId) throws ResourceNotFoundException{
        User user = userRepository.findByFacebookId(facebookId).orElseThrow(() -> new ResourceNotFoundException ("user not found on :: " + facebookId));
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> getUserById(Long Id) throws ResourceNotFoundException{
        User user = userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException ("user not found on :: " + Id));
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> getUserByFirstName(String firstName) throws ResourceNotFoundException{
        User user = userRepository.findByFirstName(firstName).orElseThrow(() -> new ResourceNotFoundException ("user not found on :: " + firstName));
        return ResponseEntity.ok().body(user);
    }

    public User createNewUser(User user){
        return userRepository.save(user);
    }

    public Map<String, Boolean> deleteAnUser(Long userId)throws ResourceNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on ::" + userId));
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

