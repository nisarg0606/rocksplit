// package com.rocksplit.dto;

// import lombok.Data;

// import java.util.HashSet;
// import java.util.Set;

// @Data
// public class UserDTO {

//     private String userId;
//     private String name;
//     private String email;
//     private String phone;
//     private String profilePicture;
//     private Set<String> groupIds = new HashSet<>();
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
public class UserDTO {

    private String id;  // Changed from userId to match entity naming convention
    private String name;
    private String email;
    private String phone;
    private String profilePicture;
    private String bio;
    private String defaultCurrency;
    private LocalDateTime createdAt;
    
    // For authentication/authorization
    private String token;  // JWT token (when needed)
    private boolean enabled;
    
    // Summary information
    private BigDecimal totalOwed;    // Total amount owed to this user
    private BigDecimal totalOwing;   // Total amount this user owes
    private BigDecimal netBalance;   // Net balance (totalOwed - totalOwing)
    
    // Groups information
    private List<GroupSummaryDTO> groups = new ArrayList<>();
    
    // Friends information
    private List<FriendDTO> friends = new ArrayList<>();
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GroupSummaryDTO {
        private String id;
        private String name;
        private String groupImage;
        private String currency;
        private int memberCount;
        private BigDecimal balance;  // User's balance in this group
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FriendDTO {
        private String id;
        private String name;
        private String email;
        private String profilePicture;
        private BigDecimal balance;  // Balance with this friend (positive means user owes friend)
    }
}