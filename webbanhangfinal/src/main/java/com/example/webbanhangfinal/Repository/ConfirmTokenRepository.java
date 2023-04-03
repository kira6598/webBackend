package com.example.webbanhangfinal.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webbanhangfinal.MVC.Model.ConfirmationUserToken;

import jakarta.transaction.Transactional;

@Repository
public interface ConfirmTokenRepository extends JpaRepository<ConfirmationUserToken,Long> {
    Optional<ConfirmationUserToken> findByToken(String UserToken);
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationUserToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
