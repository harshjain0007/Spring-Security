package com.mobile;

import com.mobile.entity.User;
import com.mobile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class MobileApplication {


	@Autowired
	private UserRepository repository;

	public void initUsers(){
		List<User> users= Stream.of(
				new User(101,"harsh","harsh"),
				new User(201,"jain","jain")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}


	public static void main(String[] args) {
		SpringApplication.run(MobileApplication.class, args);
	}

}
