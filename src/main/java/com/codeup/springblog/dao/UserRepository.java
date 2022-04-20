package com.codeup.springblog.dao;


import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);
    User findUserByEmail(String email);
    User findUserByFirstName(String first_name);
    User findUserByLastName(String last_name);
    User findUserByUsername(String username);

}