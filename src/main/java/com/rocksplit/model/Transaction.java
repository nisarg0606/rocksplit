package com.rocksplit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne @JoinColumn(name = "from_user_id")
    private User fromUser;

    @ManyToOne @JoinColumn(name = "to_user_id")
    private User toUser;

    private BigDecimal amount;

    private String currency;

    private LocalDateTime date;

    private String notes;

    @ElementCollection
    private List<Long> relatedExpenseIds;
}
