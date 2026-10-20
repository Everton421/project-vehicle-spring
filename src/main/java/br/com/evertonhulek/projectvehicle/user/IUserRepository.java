package br.com.evertonhulek.projectvehicle.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends  JpaRepository<UserModel, Integer>{
   UserModel findByName(String name);
    
}
