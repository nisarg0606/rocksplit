package com.rocksplit.service;

import com.rocksplit.dto.PaymentGraphDTO;
import com.rocksplit.dto.SettlementDTO;

import java.util.List;

public interface SettlementService {

    /**
     * Records a settlement transaction between users
     *
     * @param settlementDTO The settlement details
     * @return The recorded settlement
     */
    SettlementDTO recordSettlement(SettlementDTO settlementDTO);
    
    /**
     * Gets all settlements for a specific user
     *
     * @param userId The user ID
     * @return List of settlements involving the user
     */
    List<SettlementDTO> getUserSettlements(String userId);
    
    /**
     * Gets all settlements between two users
     *
     * @param user1Id First user ID
     * @param user2Id Second user ID
     * @return List of settlements between the users
     */
    List<SettlementDTO> getSettlementsBetweenUsers(String user1Id, String user2Id);
    
    /**
     * Gets the optimized payment graph for a group
     * Shows who should pay whom to settle all debts with minimal transactions
     *
     * @param groupId The group ID
     * @return Optimized payment graph
     */
    PaymentGraphDTO getOptimizedPaymentGraph(String groupId);
}