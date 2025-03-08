package com.rocksplit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    private String currency = "USD";
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paid_by", nullable = false)
    private User paidBy;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "split_type", nullable = false)
    private SplitType splitType = SplitType.EQUAL;
    
    @Column(name = "receipt_image")
    private String receiptImage;
    
    private String merchant;
    
    private String location;
    
    @Column(name = "expense_date")
    private LocalDateTime expenseDate;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    //not neccesary should be in Settlement table
    @Column(name = "is_settled")
    private boolean isSettled = false;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Balance> balances = new ArrayList<>();
    
    public enum SplitType {
        EQUAL, EXACT, PERCENTAGE
    }
}