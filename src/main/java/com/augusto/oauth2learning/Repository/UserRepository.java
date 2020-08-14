package com.augusto.oauth2learning.Repository;

import com.augusto.oauth2learning.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //The method we are going to use to retrieve users are:Query Creation from Method Name
    //Finding persons using the facebookid as a search criteria.
    public Optional<User> findByFacebookId(Long facebookId);
    public Optional<User> findByFirstName(String firstName);
}
