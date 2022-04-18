package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPage(){
        return "This will be the index page of all posts";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPost(@PathVariable int id){
        return "This is the future home of individual post number " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "Future home of the create a post form.";
    }

    @RequestMapping(path = "posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "You have created a post.";
    }


}