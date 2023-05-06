package com.assignment.link_shortner.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.assignment.link_shortner.domain.link;

public interface linkRepo extends MongoRepository<link, Integer> {

    @Query(value = "select * from shorten_link where originalurl = ?1")
    link findByOriginalUrl(String url);
}
