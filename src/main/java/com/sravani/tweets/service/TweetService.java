package com.sravani.tweets.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravani.tweets.model.Tweet;
import com.sravani.tweets.repository.TweetRepository;
import com.sravani.tweets.model.User;

import java.util.List;
@Service
public class TweetService {
	private final TweetRepository tweetRepository;
    private final UserService userService;

    @Autowired
    public TweetService(TweetRepository tweetRepository, UserService userService) {
        this.tweetRepository = tweetRepository;
        this.userService = userService;
    }

    public Tweet createTweet(Tweet tweet, Long userId) {
        User user = userService.getUserById(userId);
        tweet.setUser(user);
        return tweetRepository.save(tweet);
    }

    public List<Tweet> getTweetsByUser(Long userId) {
        User user = userService.getUserById(userId);
        return tweetRepository.findByUser(user);
    }

    public Tweet getTweetById(Long id) {
        return tweetRepository.findById(id)
               .orElseThrow();
    }

    public Tweet updateTweet(Long id, String content) {
        Tweet tweet = getTweetById(id);
        tweet.setContent(content);
        return tweetRepository.save(tweet);
    }

    public void deleteTweet(Long id) {
        tweetRepository.deleteById(id);
    }
	}

