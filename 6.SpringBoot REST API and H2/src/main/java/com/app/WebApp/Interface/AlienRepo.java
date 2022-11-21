package com.app.WebApp.Interface;


import org.springframework.data.repository.CrudRepository;

import com.app.WebApp.Java.Alien;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien,Integer>{
	
    List<Alien> findByAname(String aname);
    
//    @Query("from alien where id=?1 order by aname")
//    List<Alien> findByAnameSorted(String aname);
    
    List<Alien> findByAid(int aid);
    List<Alien> findByAidGreaterThan(int aid);
    List<Alien> findByAidLessThan(int aid);

}
