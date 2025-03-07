// package com.rocksplit.dto;

// import lombok.Data;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// @Data
// public class GroupDTO {

//     private String groupId;
//     private String name;
//     private String description;
//     private String createdBy;
//     private LocalDateTime createdAt;
//     private List<String> members = new ArrayList<>();
//     private String groupImage;
//     private String currency = "USD";
// }

package com.rocksplit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private String id;  // Changed from groupId to match entity naming convention
    private String name;
    private String description;
    private UserSummaryDTO createdBy;  // Enhanced with detailed user info instead of just ID
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<UserSummaryDTO> members = new ArrayList<>();  // Enhanced with user details
    private String groupImage;
    private String currency = "USD";
    
    // Summary statistics
    private BigDecimal totalSpent;
    private int expenseCount;
    private BigDecimal unSettledAmount;
    
    // To support pagination
    private boolean hasMoreExpenses;
    private Integer totalExpensePages;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSummaryDTO {
        private String id;
        private String name;
        private String email;
        private String profilePicture;
        private BigDecimal balance;  // Balance in this group (positive means owes, negative means owed)
    }
}