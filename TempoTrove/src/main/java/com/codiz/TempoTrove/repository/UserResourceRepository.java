package com.codiz.TempoTrove.repository;

import com.codiz.TempoTrove.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResourceRepository extends JpaRepository<UserModel, Long> {
    boolean existsByUsername(String username);
}
