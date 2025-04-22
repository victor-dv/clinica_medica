package br.com.clinica.clinica_medica.modules.user.useCase;

import br.com.clinica.clinica_medica.modules.user.UserEntity;
import br.com.clinica.clinica_medica.modules.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public UserEntity execute(UserEntity userEntity){
         this.userRepository
                 .findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail())
                 .ifPresent((user)->{
                     throw new InvalidParameterException();
                 });

         return this.userRepository.save(userEntity);
    }
}
