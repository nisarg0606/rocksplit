package com.rocksplit.service;

import com.rocksplit.dto.DashboardDTO;

import java.math.BigDecimal;
import java.util.Map;

public interface UserBalanceService {

    /**
     * Gets the user's overall balance across all groups and friends
     *
     * @param userId The user ID
     * @return Dashboard with all balance information
     */
    DashboardDTO getUserDashboard(String userId);
    
    /**
     * Gets the user's balance within a specific group
     *
     * @param userId The user ID
     * @param groupId The group ID
     * @return Map of user IDs to their balance amounts (positive means they owe, negative means they are owed)
     */
    Map<String, BigDecimal> getUserGroupBalance(String userId, String groupId);
    
    /**
     * Gets the balance between two specific users
     *
     * @param user1Id First user ID
     * @param user2Id Second user ID
     * @return Balance amount (positive means user1 owes user2, negative means user2 owes user1)
     */
    BigDecimal getBalanceBetweenUsers(String user1Id, String user2Id);
    
    /**
     * Calculates the total amount a user is owed by others
     *
     * @param userId The user ID
     * @return Total amount owed to the user
     */
    BigDecimal getTotalOwedToUser(String userId);
    
    /**
     * Calculates the total amount a user owes to others
     *
     * @param userId The user ID
     * @return Total amount the user owes
     */
    BigDecimal getTotalUserOwes(String userId);
}