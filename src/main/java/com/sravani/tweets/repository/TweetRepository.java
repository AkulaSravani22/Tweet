package com.sravani.tweets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sravani.tweets.model.Tweet;
import com.sravani.tweets.model.User;
@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {
    List<Tweet> findByUser(User user);

}

