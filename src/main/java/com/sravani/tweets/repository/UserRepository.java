package com.sravani.tweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sravani.tweets.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	

}
