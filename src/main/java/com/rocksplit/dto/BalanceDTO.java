package com.rocksplit.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceDTO {
    private Long id;
    private String expenseId;
    private String userId;
    private String userName;
    private BigDecimal amount;
}