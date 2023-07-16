package com.sravani.tweets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sravani.tweets.model.Tweet;
import com.sravani.tweets.service.TweetService;

@RestController
@RequestMapping("/tweet")
public class TweetController {
	private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Tweet> createTweet(
            @RequestBody Tweet tweet,
            @PathVariable("userId") Long userId
    ) {
        Tweet createdTweet = tweetService.createTweet(tweet, userId);
        return new ResponseEntity<>(createdTweet, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Tweet>> getTweetsByUser(@PathVariable("userId") Long userId) {
        List<Tweet> tweets = tweetService.getTweetsByUser(userId);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

    @GetMapping("/{tweetId}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable("tweetId") Long tweetId) {
        Tweet tweet = tweetService.getTweetById(tweetId);
        return new ResponseEntity<>(tweet, HttpStatus.OK);
    }

    @PutMapping("/{tweetId}")
    public ResponseEntity<Tweet> updateTweet(
            @PathVariable("tweetId") Long tweetId,
            @RequestBody String content
    ) {
        Tweet updatedTweet = tweetService.updateTweet(tweetId, content);
        return new ResponseEntity<>(updatedTweet, HttpStatus.OK);
    }

    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@PathVariable("tweetId") Long tweetId) {
        tweetService.deleteTweet(tweetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

	}

