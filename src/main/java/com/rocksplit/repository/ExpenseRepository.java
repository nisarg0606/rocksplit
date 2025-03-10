package com.rocksplit.repository;

import com.rocksplit.model.Expense;
import com.rocksplit.model.Group;
import com.rocksplit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, String> {
    
//    List<Expense> findByGroup(Group group);
//
//    List<Expense> findByPaidBy(User paidBy);
//
//    @Query("SELECT e FROM Expense e JOIN e.balances b WHERE b.user = :user")
//    List<Expense> findExpensesByUser(User user);
//
//    @Query("SELECT e FROM Expense e WHERE e.group.id = :groupId")
//    List<Expense> findExpensesByGroupId(String groupId);
//
//    @Query("SELECT e FROM Expense e WHERE e.paidBy.id = :userId AND e.group.id = :groupId")
//    List<Expense> findExpensesByUserIdAndGroupId(String userId, String groupId);
//
//    @Query("SELECT e FROM Expense e WHERE e.expenseDate BETWEEN :startDate AND :endDate")
//    List<Expense> findExpensesBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
//
//    @Query("SELECT e FROM Expense e WHERE e.isSettled = :isSettled")
//    List<Expense> findBySettlementStatus(boolean isSettled);
}