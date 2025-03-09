package com.rocksplit.repository;

import com.rocksplit.model.Group;
import com.rocksplit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
    
//    List<Group> findByCreatedBy(User user);
//
//    @Query("SELECT g FROM Group g JOIN g.members m WHERE m.id = :userId")
//    List<Group> findGroupsByUserId(String userId);
//
//    @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM Group g JOIN g.members m WHERE g.id = :groupId AND m.id = :userId")
//    boolean isUserInGroup(String groupId, String userId);
}