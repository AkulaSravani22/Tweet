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
import com.sravani.tweets.model.User;
@RestController
@RequestMapping("/users")
public class UsersController {

	    private final UsersService userService;

	    @Autowired
	    public UsersController(UsersService userService) {
	        this.userService = userService;
	    }

	    @PostMapping
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User createdUser = userService.createUser(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }

	    @GetMapping("/gettweets/{userId}")
	    public ResponseEntity<List<Tweet>> getTweetsByUserId(@PathVariable("userId") Long userId) {
	        List<Tweet> tweets = userService.getTweetsByUserId(userId);
	        if (tweets != null) {
	            return new ResponseEntity<>(tweets, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @GetMapping("/tweets/{tweetId}")
	    public ResponseEntity<Tweet> getTweetById(@PathVariable("tweetId") Long tweetId) {
	        Tweet tweet = userService.getTweetById(tweetId);
	        if (tweet != null) {
	            return new ResponseEntity<>(tweet, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @PostMapping("/createtweet/{userId}")
	    public ResponseEntity<Tweet> createTweet(@PathVariable Long userId, @RequestBody Tweet tweet) {
	        Tweet createdTweet = userService.createTweet(userId, tweet);
	        if (createdTweet != null) {
	            return new ResponseEntity<>(createdTweet, HttpStatus.CREATED);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @PutMapping("/update/{tweetId}")
	    public ResponseEntity<Tweet> updateTweet(@PathVariable("tweetId") Long tweetId, @RequestBody String updatedContent) {
	        Tweet updatedTweet = userService.updateTweet(tweetId, updatedContent);
	        if (updatedTweet != null) {
	            return new ResponseEntity<>(updatedTweet, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @DeleteMapping("/deletetweets/{tweetId}")
	    public ResponseEntity<Void> deleteTweet(@PathVariable("tweetId") Long tweetId) {
	        userService.deleteTweet(tweetId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}

