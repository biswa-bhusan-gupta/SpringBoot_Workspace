package com.app.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.jpa.entities.User;


public interface UserRepository extends CrudRepository<User,Integer>{
	
	
  public List<User> findByName(String name);
  public List<User> findByCityAndStatus(String city,String status);

  public List<User> findByNameStartingWith(String name);
  public List<User> findByNameEndingWith(String name);
  public List<User> findByNameContaining(String name);
  
  @Query("SELECT u FROM User u")
  public List<User> getAllUser();
  
  @Query("SELECT u FROM User u WHERE u.name = :n AND u.city = :c")
  public List<User> getUserByNameAndCity(@Param("n") String name,@Param("c") String city);  
  
  
  @Query(value="SELECT * FROM User",nativeQuery=true)
  public List<User> getAllUsers();
  
}
