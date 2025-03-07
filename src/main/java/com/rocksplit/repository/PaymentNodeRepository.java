package com.rocksplit.repository;

import com.rocksplit.model.Group;
import com.rocksplit.model.PaymentNode;
import com.rocksplit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentNodeRepository extends JpaRepository<PaymentNode, Long> {
    
    List<PaymentNode> findByGroup(Group group);
    
    List<PaymentNode> findByFromUser(User fromUser);
    
    List<PaymentNode> findByToUser(User toUser);
    
    @Query("SELECT p FROM PaymentNode p WHERE p.group.id = :groupId")
    List<PaymentNode> findByGroupId(String groupId);
    
    @Query("SELECT p FROM PaymentNode p WHERE p.fromUser.id = :userId OR p.toUser.id = :userId")
    List<PaymentNode> findByUserId(String userId);
    
    @Query("SELECT p FROM PaymentNode p WHERE p.isSettled = :isSettled")
    List<PaymentNode> findBySettlementStatus(boolean isSettled);
}