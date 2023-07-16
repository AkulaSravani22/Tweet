package com.sravani.tweets.controller;

import org.springframework.stereotype.Service;

import com.sravani.tweets.model.Tweet;
import com.sravani.tweets.model.User;
import com.sravani.tweets.repository.TweetRepository;
import com.sravani.tweets.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;


	@Service
	public class UsersService {
	    private final UserRepository userRepository;
	    private final TweetRepository tweetRepository;

	    @Autowired
	    public UsersService(UserRepository userRepository, TweetRepository tweetRepository) {
	        this.userRepository = userRepository;
	        this.tweetRepository = tweetRepository;
	    }

	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    public List<Tweet> getTweetsByUserId(Long userId) {
	        Optional<User> optionalUser = userRepository.findById(userId);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            return user.getTweets();
	        }
	        return null;
	    }

	    public Tweet getTweetById(Long tweetId) {
	        Optional<Tweet> optionalTweet = tweetRepository.findById(tweetId);
	        return optionalTweet.orElse(null);
	    }

	    public Tweet createTweet(Long userId, Tweet tweet) {
	        Optional<User> optionalUser = userRepository.findById(userId);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            tweet.setUser(user);
	            return tweetRepository.save(tweet);
	        }
	        return null;
	    }

	    public Tweet updateTweet(Long tweetId, String updatedContent) {
	        Optional<Tweet> optionalTweet = tweetRepository.findById(tweetId);
	        if (optionalTweet.isPresent()) {
	            Tweet tweet = optionalTweet.get();
	            tweet.setContent(updatedContent);
	            return tweetRepository.save(tweet);
	        }
	        return null;
	    }

	    public void deleteTweet(Long tweetId) {
	        tweetRepository.deleteById(tweetId);
	    }
	}

