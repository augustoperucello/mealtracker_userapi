package com.augusto.oauth2learning.Controllers;

import com.augusto.oauth2learning.Exceptions.CannotSaveResourceException;
import com.augusto.oauth2learning.Exceptions.ResourceNotFoundException;
import com.augusto.oauth2learning.Entities.User;
import com.augusto.oauth2learning.Service.UserService;

import java.util.List;
import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    private UserService userService;

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

    @Path("/users")
    @POST
    public User createUser(User user) throws CannotSaveResourceException {
        return userService.createNewUser(user);
    }

    //Updating the user by UserID

    @Path("/users/{id}")
    @PUT
    public User updateUserById(
        @PathParam("id") Long userId, User userDetails)
        throws CannotSaveResourceException, ResourceNotFoundException{
            return userService.updateUserById(userId, userDetails);
        }

    @Path("/facebook/{fbid}")
    @PUT
    public User updateUserByFacebookId(
            @PathParam("fbid") Long facebookId, User userDetails)
            throws ResourceNotFoundException, CannotSaveResourceException{
        return userService.updateUserByFacebookId(facebookId, userDetails);
    }

    @Path("/users/{id}")
    @DELETE
    public Map<String, Boolean> deleteUser (@PathParam("id") Long userId) throws Exception {
        return userService.deleteAnUser(userId);
    }

    @Path("/facebook/{fbid}")
    @DELETE
    public Map<String, Boolean> deleteUserByFacebookId (@PathParam("fbid") Long facebookId) throws Exception {
        return userService.deleteAnUserByFacebookId(facebookId);
    }

    }

