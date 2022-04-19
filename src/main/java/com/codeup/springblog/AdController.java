//package com.codeup.springblog;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//class AdController {
//    // ...
//    private final AdRepository adDao;
//
//    public AdController(AdRepository adDao) {
//        this.adDao = adDao;
//    }
//    @GetMapping("/ads")
//    public String getAd(Model model) {
//        return "adPage";
//    }
//
//    // ...
//}