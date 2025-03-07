package com.rocksplit.repository;

import com.rocksplit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    Optional<User> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    @Query("SELECT u FROM User u JOIN u.groups g WHERE g.id = :groupId")
    List<User> findUsersByGroupId(String groupId);
    
    @Query("SELECT u FROM User u WHERE u.id IN :userIds")
    Set<User> findAllByIds(Set<String> userIds);
}