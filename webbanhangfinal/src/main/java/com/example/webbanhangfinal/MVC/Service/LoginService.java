package com.example.webbanhangfinal.MVC.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.example.webbanhangfinal.MVC.Model.AppUser;
import com.example.webbanhangfinal.Repository.UserRepository;
import com.example.webbanhangfinal.auththenticate.Login.LoginHandle.LoginRequest;
import com.example.webbanhangfinal.auththenticate.Login.LoginHandle.LoginRespone;
import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final CartService cartService;

    public AppUser getUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public LoginRespone authenticateRequest(LoginRequest request) {
        var user = getUserByEmail(request.email());
        if(user==null){
            LoginRespone respone = new LoginRespone(null,null,"user is not exist!",0);
            return respone;
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
               );// throw ex đã có GlobalExeptionHandler catch
      
        var jwtToken = jwtService.generateToken(user);
        long countItemUser = cartService.getCountItemByEmail(request.email());
        LoginRespone respone = new LoginRespone(user.getId(),user.getFirstname()+" "+user.getLastname(),jwtToken,countItemUser);
         return respone;
    }

   
    
}
