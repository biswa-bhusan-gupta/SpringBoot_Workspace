package com.app.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.app.jpa.entities.User;
import com.app.jpa.repo.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;





@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(Application.class, args);
		
		UserRepository repo = context.getBean(UserRepository.class); // WE GET OBJECTS AS BEANS FOR CRUD OPERATION 
        
//		User user = new User();
//		user.setName("Biswa Bhusan Gupta");
//		user.setCity("New Delhi");
//		user.setStatus("WFH");
//		
//		User obj = repo.save(user);
//		System.out.println(obj);
		
		
//		User user1 = new User();
//		user1.setName("Yash Gupta");
//		user1.setCity("Bangalore");
//		user1.setStatus("WFH");
//		
//		User user2 = new User();
//		user2.setName("Shreyash Santanu");
//		user2.setCity("Hyderabad");
//		user2.setStatus("WFO");
//		
//		
//		
//		List<User> userList = new ArrayList<>();
//		userList.add(user1);
//		userList.add(user2);
//		
//		repo.saveAll(userList);
//		
//		userList.forEach(i->{
//			System.out.println(i);
//		});
		
		// Find and Update Data in Database
//		Optional<User> optional = repo.findById(1);
//		System.out.println(optional);
//		
//		User user =  optional.get();
//		user.setName("Tushar Srivastava");
//		
//		User obj = repo.save(user);
//		System.out.println("Changes made to ID :"+obj);
		
		// Find All
		Iterable<User> allUsers = repo.findAll();
		
		Iterator<User> it = allUsers.iterator();
		   while(it.hasNext()) {
			   System.out.println(it.next());
		   }
		
//		allUsers.forEach(i->{System.out.println(i);});
		   
		// Delete All   
//      repo.deleteAll(allUsers);
		   
		// Custom :   
		User findUser = repo.findByName("Tushar Srivastava");		
		System.out.println(findUser);
//		findUser.forEach(i->{System.out.println(i);});
		
		List<User> findCityStatus = repo.findByCityAndStatus("Bangalore","WFH");		
		System.out.println(findCityStatus);
		
		List<User> findName = repo.findByNameStartingWith("S");		
		System.out.println(findName);
		
		List<User> allUsers1 = repo.getAllUser();
		allUsers1.forEach(r->{System.out.println(r);});
		
		
		System.out.println("<--------------------------------------- Important ----------------------------------------------------->");
	    repo.getUserByNameAndCity("Shreyash Santanu","Hyderabad").forEach(x-> {System.out.println(x);});
	    repo.getAllUser().forEach(x-> {System.out.println(x);});
	}
}
