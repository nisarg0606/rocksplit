package com.rocksplit.repository;

import com.rocksplit.model.Balance;
import com.rocksplit.model.Expense;
import com.rocksplit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    
    List<Balance> findByExpense(Expense expense);
    
    List<Balance> findByUser(User user);
    
    @Query("SELECT b FROM Balance b WHERE b.user.id = :userId AND b.expense.group.id = :groupId")
    List<Balance> findByUserIdAndGroupId(String userId, String groupId);
    
    @Query("SELECT SUM(b.amount) FROM Balance b WHERE b.user.id = :userId")
    BigDecimal sumBalanceByUserId(String userId);
    
    @Query("SELECT SUM(b.amount) FROM Balance b WHERE b.user.id = :userId AND b.expense.group.id = :groupId")
    BigDecimal sumBalanceByUserIdAndGroupId(String userId, String groupId);
}