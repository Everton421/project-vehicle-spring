package br.com.evertonhulek.projectvehicle.user;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data 
@Entity( name = "users")
public class UserModel {

        @Id 
        @GeneratedValue ( strategy = GenerationType.IDENTITY)
        private int id;
        @Column(nullable = false, unique = true)
        private  String name;
        @Column(nullable = false)
        private  String email;
        @Column(nullable = false)
        private  String password;

        @CreationTimestamp 
        @Column( nullable = false,  updatable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
        private LocalDateTime created_at; 

}
