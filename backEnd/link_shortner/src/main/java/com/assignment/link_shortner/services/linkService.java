package com.assignment.link_shortner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.link_shortner.repos.linkRepo;
import com.assignment.link_shortner.domain.link;
import static com.assignment.link_shortner.logic.shortLink.getShortUrl;
import static com.assignment.link_shortner.logic.shortLink.isUrlValid;

@Service
public class linkService {
    @Autowired
    private linkRepo linkRepo;

    public link getOriginlUrl(String url) {
        return linkRepo.findByOriginalUrl(url);
    }

    public link generateShortUrl(String url) {
        if (!isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }

        link urlObject = new link();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));

        return linkRepo.save(urlObject);
    }

}
