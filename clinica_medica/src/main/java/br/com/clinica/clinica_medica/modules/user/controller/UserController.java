package br.com.clinica.clinica_medica.modules.user.controller;

import br.com.clinica.clinica_medica.modules.user.UserEntity;
import br.com.clinica.clinica_medica.modules.user.useCase.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping("/register/")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity){
        try {
            var result = createUserUseCase.execute(userEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
