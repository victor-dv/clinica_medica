package br.com.clinica.clinica_medica.modules.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    //Procurando pelo username ou email que foram passados
    Optional<UserEntity> findByUsernameOrEmail(String username,String email);
}
