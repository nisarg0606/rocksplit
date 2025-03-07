package com.rocksplit.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DashboardDTO {
    private UserDTO currentUser;
    private List<GroupSummaryDTO> groupSummaries = new ArrayList<>();
    private List<FriendBalanceDTO> friendBalances = new ArrayList<>();
    private BigDecimal totalOwed;
    private BigDecimal totalOwing;
    private BigDecimal netBalance;
    
    @Data
    public static class GroupSummaryDTO {
        private String groupId;
        private String groupName;
        private BigDecimal netBalance;
        private Map<String, BigDecimal> memberBalances = new HashMap<>();
    }
    
    @Data
    public static class FriendBalanceDTO {
        private String userId;
        private String userName;
        private String profilePicture;
        private BigDecimal netBalance;
    }
}