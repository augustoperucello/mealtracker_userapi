package com.augusto.oauth2learning.Controllers;

import com.augusto.oauth2learning.Exceptions.CannotSaveResourceException;
import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Service.UserService;

import java.util.List;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @Path("/users")
    @GET
    public List<User> getAllUsers()throws ResourceNotFoundException{
        return userService.getAllUsers();
    }

    @Path("/users/{id}")
    @GET
    public User getUserById(@PathParam("id") Long id)
        throws ResourceNotFoundException {
        return userService.getUserById(id);
    }

    @Path("facebook/{fbid}")
    @GET
    public User getUserByFacebookId(@PathParam("fbid") Long facebookId)
            throws ResourceNotFoundException {
        return userService.getUserByFacebookId(facebookId);
    }

    @Path("username/{firstName}")
    @GET
    public User getUserByFirstName(@PathParam("firstName") String firstName)
            throws ResourceNotFoundException {
        return userService.getUserByFirstName(firstName);
    }

    @Transactional
    @Path("/users")
    @POST
    public User createUser(User user) throws CannotSaveResourceException {
        return userService.createNewUser(user);
    }

    //Updating the user by UserID

    @Transactional
    @Path("/users/{id}")
    @PUT
    public User updateUserById(
        @PathParam("id") Long userId, User userDetails)
        throws CannotSaveResourceException, ResourceNotFoundException{
            return userService.updateUserById(userId, userDetails);
        }

    @Transactional
    @Path("/facebook/{fbid}")
    @PUT
    public User updateUserByFacebookId(
            @PathParam("fbid") Long facebookId, User userDetails)
            throws NotFoundException, CannotSaveResourceException{
        return userService.updateUserByFacebookId(facebookId, userDetails);
    }

    @Transactional
    @Path("/users/{id}")
    @DELETE
    public Map<String, Boolean> deleteUser (@PathParam("id") Long userId) throws Exception {
        return userService.deleteAnUser(userId);
    }

    @Transactional
    @Path("/facebook/{fbid}")
    @DELETE
    public Map<String, Boolean> deleteUserByFacebookId (@PathParam("fbid") Long facebookId) throws Exception {
        return userService.deleteAnUserByFacebookId(facebookId);
    }

    }

