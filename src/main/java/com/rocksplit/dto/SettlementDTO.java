package com.rocksplit.dto;

import com.rocksplit.model.Settlement.SettlementMethod;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SettlementDTO {
    private String id;
    private String fromUserId;
    private String fromUserName;
    private String toUserId;
    private String toUserName;
    private String groupId;
    private String groupName;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime createdAt;
    private String notes;
    private SettlementMethod method;
    private String settlementProof;
}