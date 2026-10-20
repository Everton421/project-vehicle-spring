package br.com.evertonhulek.projectvehicle.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.evertonhulek.projectvehicle.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class FilterVehicleAuth extends OncePerRequestFilter {

    @Autowired 
    private  IUserRepository userRepository;
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                // 1 - Obter dados da Autenticação ( usuario, senha ) 
                // 2 - validar usuario e senha

                    var servletPath = request.getServletPath();
                    if( !servletPath.equals("/login") ){


                    // obtem o header da requisicao.
                    var authorization = request.getHeader("Authorization");
                    
                    // separa a String "Basic" da credencial
                    var credentialsEncoded = authorization.substring("Basic".length()).trim();
                    // decodifica a credencial vindo em base64
                    var credentialsDecoded = Base64.getDecoder().decode(credentialsEncoded);

                    // Transforma a credencial em string.
                    var stringCredential = new String(credentialsDecoded);
                    // separa o usuario da senha.
                    String[]  credentials = stringCredential.split( ":");

                    
                    String user =  credentials[0];
                    String password =  credentials[1];


                        var existsUser = this.userRepository.findByName(user);
                            if(existsUser == null){
                                response.sendError(401); 
                            }else{
                               var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), existsUser.getPassword());
                               if(passwordVerify.verified){
                                  filterChain.doFilter(request, response);
                               }else{
                                    response.sendError(401);
                               }     
                        }
                    }else{
                                  filterChain.doFilter(request, response);

                    }
 
                    //System.out.println(" (!) credentials");
                    //System.out.println(" User: "+user+" Pasword: "+ password);


    }

 
    
}
