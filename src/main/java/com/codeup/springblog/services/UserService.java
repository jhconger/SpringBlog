//package com.codeup.springblog.services;
//
//import com.codeup.springblog.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//@Service("userService")
//public class UserService {
//
//    private final UserRepository userDao;
//
//    public UserService(UserRepository userDao){
//        this.userDao = userDao;
//    }
//
//    public User loggedInUser(){
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user.getUsername() == null){
//            System.out.println("no currently logged in user");
//            return null;
//        }
//        System.out.println("Grabbing current user : " + user.getUsername());
//        return userDao.findById(user.getId()).get();
//    }
//}