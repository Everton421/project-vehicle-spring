package br.com.evertonhulek.projectvehicle.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;



@RestController 
@RequestMapping ("/users")
public class UserController {
    @Autowired 
    private IUserRepository userRepository;

      
         @PostMapping("")
         public ResponseEntity createUser(@RequestBody UserModel user) {

                var userVerify = this.userRepository.findByName(user.getName());
                
                if(userVerify != null) {
                    return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new   Error("usuario já existe").getMessage());
                }

                    // toCharArray: converte uma string em um char array
                    // gera o hash da senha.
                    var passwordHashed = BCrypt.withDefaults()
                    .hashToString(12, user.getPassword().toCharArray());

                 user.setPassword(passwordHashed);

                var usercreated = this.userRepository.save(user);
             return   ResponseEntity.status(201).body(usercreated);
         }
         
}   
