//package com.rocksplit.model;
//
//// No need of this table although we can have a object which can have all this and a current split to differnciate between all the transaction as we have it in splitwise
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "balances")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Balance {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "expense_id", nullable = false)
//    private Expense expense;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @Column(nullable = false)
//    private BigDecimal amount;
//
//    // Positive amount means user owes money (will pay)
//    // Negative amount means user is owed money (will receive)
//}