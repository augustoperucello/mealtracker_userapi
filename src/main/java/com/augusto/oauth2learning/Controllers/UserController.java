package com.augusto.oauth2learning.Controllers;

import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import com.augusto.oauth2learning.Repository.UserRepository;
import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    //Now we are going to start to map all the URIs. Remember we map METHODS To URLS. So this method above
    //returns a LIST of User. Remember that this is a generic. We are saying that only the object of type User
    //can be inside that list, eliminating runtime problems

    //This endpoint gets all users. Easy
    @GetMapping("/users")
    public List<User> getAllUsers()throws ResourceNotFoundException{
        return userService.getAllUsers();
    }

    //This next one gets the user by their ID. The PathVariable is the variable received in the QueryParameter
    //userId is the variable inside the method. This method is harder to understand. Here, we are
    //instantiating a User variable. Then we call the method findById in the User com.augusto.oauth2learning.Repository

    @GetMapping("/users/{id}")
    //Gets an specific user by ID
    public ResponseEntity<User> getUserById(@PathVariable(value="id") Long id)
        throws ResourceNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping("facebook/{fbid}")
    //Gets an specific user by FacebookID
    public ResponseEntity<User> getUserByFacebookId(@PathVariable(value="fbid") Long facebookId)
            throws ResourceNotFoundException {
        return userService.getUserByFacebookId(facebookId);
    }

    @GetMapping("username/{firstName}")
    //Gets an specific user by FacebookID
    public ResponseEntity<User> getUserByFirstName(@PathVariable(value="firstName") String firstName)
            throws ResourceNotFoundException {
        return userService.getUserByFirstName(firstName);
    }

    //Creating a new user with Post. RequestBody takes the body on the request and passes it to the User variable
    //This return will also trigger save on userRepository

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userService.createNewUser(user);
    }

    //Updating the user by UserID

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserById(
        @PathVariable(value="id") Long userId, @Valid @RequestBody User userDetails)
        throws ResourceNotFoundException{
            return userService.updateUserById(userId, userDetails);
        }

        //Updating an User by FacebookID
    @PutMapping("/facebook/{fbid}")
    public ResponseEntity<User> updateUserByFacebookId(
            @PathVariable(value="fbid") Long facebookId, @Valid @RequestBody User userDetails)
            throws ResourceNotFoundException{
        return userService.updateUserByFacebookId(facebookId, userDetails);
    }

        //And lastly, deleting an user.
        //We are using generics here. The implementation will be a hash map, with fully existing methods like put and remove.

    //Deleting an user by UserID
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value="id") Long userId) throws Exception {
        return userService.deleteAnUser(userId);
    }

    //Deleting an user by FacebookID
    @DeleteMapping("/facebook/{fbid}")
    public Map<String, Boolean> deleteUserByFacebookId (@PathVariable(value="fbid") Long facebookId) throws Exception {
        return userService.deleteAnUserByFacebookId(facebookId);
    }

    }

