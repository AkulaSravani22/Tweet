package com.sravani.tweets.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sravani.tweets.model.User;
import com.sravani.tweets.repository.UserRepository;


@Service
public class UserService {
	

	
	    private final UserRepository userRepository;

	    @Autowired
	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    public User getUserById(Long id) {
	        try {
				return userRepository.findById(id)
				        .orElseThrow(() -> new NotFoundException());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }

	    // Other methods if needed
	}


