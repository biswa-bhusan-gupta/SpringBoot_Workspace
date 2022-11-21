package com.app.SpringDataREST.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel="Aliens",path="Aliens")
public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
