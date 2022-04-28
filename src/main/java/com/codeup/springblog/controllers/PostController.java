package com.codeup.springblog.controllers;

import com.codeup.springblog.model.PostImage;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postsDao;
    private final EmailService emailService;

    public PostController(PostRepository postsDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.emailService = emailService;
    }

    @GetMapping(path = "/posts")
    public String indexPage(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.findPostById(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String getPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String create(@ModelAttribute Post post, @RequestParam String imageUrl) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        post.setImages(imageUrl);
        Post savedPost = postsDao.save(post);
        String subject = "New Ad Created: " + savedPost.getTitle();
        String body = "Dear " + savedPost.getUser().getUsername() + ", Thank you for creating an Ad. Your ad is: " + savedPost.getId();
//         send email to the user
        emailService.prepareAndSend(post, "New Post Created", post.getBody());
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping(path = "/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getById(id));
        return "posts/edit";
    }

    @PostMapping(path = "/posts/{id}/edit")
    public String edit(@PathVariable long id,
                       @RequestParam(name = "title") String title,
                       @RequestParam(name = "body") String body,
                       Model model) {

        Post post = postsDao.getById(id);
        post.setTitle(title);
        post.setBody(body);


        model.addAttribute("post", postsDao.saveAndFlush(post));
        return "redirect:/posts/" + id;
    }

    @PostMapping(path = "/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }


}