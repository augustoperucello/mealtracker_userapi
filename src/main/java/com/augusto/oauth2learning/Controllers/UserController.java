package com.augusto.oauth2learning.Controllers;

import com.augusto.oauth2learning.Exceptions.CannotSaveResourceException;
import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Service.UserService;


import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserController {

    @Inject
    private UserService userService;

    @Path("/users")
    @GET
    public List<User> getAllUsers()throws ResourceNotFoundException{
        return userService.getAllUsers();
    }

    @Path("/users/{id}")
    @GET
    public User getUserById(@PathParam(value="id") Long id)
        throws ResourceNotFoundException {
        return userService.getUserById(id);
    }

    @Path("facebook/{fbid}")
    @GET
    public User getUserByFacebookId(@PathParam(value="fbid") Long facebookId)
            throws ResourceNotFoundException {
        return userService.getUserByFacebookId(facebookId);
    }

    @Path("username/{firstName}")
    @GET
    public User getUserByFirstName(@PathParam(value="firstName") String firstName)
            throws ResourceNotFoundException {
        return userService.getUserByFirstName(firstName);
    }

    @Path("/users")
    @POST
    public User createUser(User user) throws CannotSaveResourceException {
        return userService.createNewUser(user);
    }

    //Updating the user by UserID

    @Path("/users/{id}")
    @PUT
    public User updateUserById(
        @PathParam(value="id") Long userId, User userDetails)
        throws CannotSaveResourceException, ResourceNotFoundException{
            return userService.updateUserById(userId, userDetails);
        }

    @Path("/facebook/{fbid}")
    @PUT
    public User updateUserByFacebookId(
            @PathParam(value="fbid") Long facebookId, User userDetails)
            throws ResourceNotFoundException, CannotSaveResourceException{
        return userService.updateUserByFacebookId(facebookId, userDetails);
    }

    @Path("/users/{id}")
    @DELETE
    public Map<String, Boolean> deleteUser (@PathParam(value="id") Long userId) throws Exception {
        return userService.deleteAnUser(userId);
    }

    @Path("/facebook/{fbid}")
    @DELETE
    public Map<String, Boolean> deleteUserByFacebookId (@PathParam(value="fbid") Long facebookId) throws Exception {
        return userService.deleteAnUserByFacebookId(facebookId);
    }

    }

