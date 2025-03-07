package com.rocksplit.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class PaymentGraphDTO {
    private String groupId;
    private String groupName;
    private List<PaymentNodeDTO> payments = new ArrayList<>();
    
    @Data
    public static class PaymentNodeDTO {
        private String fromUserId;
        private String fromUserName;
        private String toUserId;
        private String toUserName;
        private BigDecimal amount;
        private String currency;
    }
}