package com.rocksplit.dto;

//import com.rocksplit.model.Expense.SplitType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ExpenseDTO {
    private String id;
    private String title;
    private BigDecimal amount;
    private String currency;
    private String paidById;
    private String paidByName;
    private String groupId;
    private String groupName;
//    private SplitType splitType;
    private String receiptImage;
    private String merchant;
    private String location;
    private LocalDateTime expenseDate;
    private LocalDateTime createdAt;
    private boolean settled;
    private List<BalanceDTO> balances = new ArrayList<>();
}