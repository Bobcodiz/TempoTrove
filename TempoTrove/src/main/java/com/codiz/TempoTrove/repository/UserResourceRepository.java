package com.codiz.TempoTrove.repository;

import com.codiz.TempoTrove.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserResourceRepository extends JpaRepository<UserModel, Long> {
    boolean existsByUsername(String username);

    Optional<UserModel> findByUsername(String username);
}
