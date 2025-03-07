package com.rocksplit.repository;

import com.rocksplit.model.Group;
import com.rocksplit.model.Settlement;
import com.rocksplit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, String> {
    
    List<Settlement> findByFromUser(User fromUser);
    
    List<Settlement> findByToUser(User toUser);
    
    List<Settlement> findByGroup(Group group);
    
    @Query("SELECT s FROM Settlement s WHERE s.fromUser.id = :userId OR s.toUser.id = :userId")
    List<Settlement> findByUserId(String userId);
    
    @Query("SELECT s FROM Settlement s WHERE (s.fromUser.id = :userId1 AND s.toUser.id = :userId2) OR (s.fromUser.id = :userId2 AND s.toUser.id = :userId1)")
    List<Settlement> findBetweenUsers(String userId1, String userId2);
    
    @Query("SELECT s FROM Settlement s WHERE s.group.id = :groupId AND (s.fromUser.id = :userId OR s.toUser.id = :userId)")
    List<Settlement> findByGroupIdAndUserId(String groupId, String userId);
}