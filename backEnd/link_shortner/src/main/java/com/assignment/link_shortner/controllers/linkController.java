package com.assignment.link_shortner.controllers;

import com.assignment.link_shortner.domain.link;
import com.assignment.link_shortner.services.linkService;

// import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("url/shortner")
@CrossOrigin(origins = "http://localhost:4200")
public class linkController {
    @Autowired
    private linkService linkService;

    @PostMapping
    public link generateShortUrl(@RequestBody String url) {
        System.out.println(url);
        return linkService.generateShortUrl(url);
    }

}
