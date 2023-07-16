package com.sravani.tweets.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="users")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	  //  @Column(nullable = false)
	    //private String username;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<Tweet> tweets;
	    
		public Long getId() {
			return id;
		}

		public List<Tweet> getTweets() {
			return tweets;
		}

		public void setTweets(List<Tweet> tweets) {
			this.tweets = tweets;
		}

		public void setId(Long id) {
			this.id = id;
		}

		//public String getUsername() {
	//		return username;
		//}

	//	public void setUsername(String username) {
		//	this.username = username;
		//}

		public User(Long id, List<Tweet> tweets) {
			super();
			this.id = id;
		//	this.username = username;
			this.tweets = tweets;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		

	    // Getters and setters

	    // Constructors
	}
