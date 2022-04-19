package com.codeup.springblog;

import com.codeup.springblog.dao.PostRepository;
import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postsDao;


    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
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
    @GetMapping(path = "/posts")
    public String indexPage(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }
    @PostMapping(path = "/posts/create")
    public String create(@ModelAttribute Post post) {
        User user = post.getUser();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts/" + post.getId();
    }
//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    public String indexPage(Model model) {
//        List<Post> posts = new ArrayList<>(Arrays.asList(
//                new Post("The weather today...", "is not the greatest!"),
//                new Post("The Batman...","was released yesterday.  After watching about half the film it seems a bit disappointing."))
//        );
//
//        model.addAttribute("posts", posts);
//        return "/posts/index";
//    }

//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    public String viewPost(@PathVariable int id, Model model) {
//        Post post = new Post("Wants VS Needs", "I really want to go get some coffee but I need to work on this project.");
//        model.addAttribute("post", post);
//        return "/posts/show";
//    }

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String create() {
//        return "Future home of the create a post form.";
//    }

//    @RequestMapping(path = "posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String createPost() {
//        return "You have created a post.";
//    }

}