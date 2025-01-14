package com.mozcalti.gamingapp.repository;

import com.mozcalti.gamingapp.model.Usuario;
import com.mozcalti.gamingapp.model.security.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
    Optional<VerificationToken> findByUsuario(Usuario user);
}
