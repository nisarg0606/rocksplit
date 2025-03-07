package com.rocksplit.service;

import com.rocksplit.dto.BalanceDTO;
import com.rocksplit.dto.ExpenseDTO;
import com.rocksplit.model.Expense.SplitType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExpenseSplitService {

    /**
     * Splits an expense amount among users based on the specified split type
     *
     * @param total     The total expense amount
     * @param userIds   List of user IDs to split the expense among
     * @param splitType The type of split (EQUAL, EXACT, PERCENTAGE)
     * @param splitDetails Map containing user-specific split details (amounts or percentages)
     * @return List of BalanceDTO with calculated splits
     */
    List<BalanceDTO> calculateSplit(BigDecimal total, 
                                   List<String> userIds, 
                                   SplitType splitType, 
                                   Map<String, BigDecimal> splitDetails);

    /**
     * Creates a new expense with calculated balances
     *
     * @param expenseDTO The expense details
     * @return Created expense with all balance details
     */
    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    /**
     * Updates an existing expense
     *
     * @param expenseDTO Updated expense details
     * @return Updated expense with recalculated balances
     */
    ExpenseDTO updateExpense(ExpenseDTO expenseDTO);
    
    /**
     * Mark an expense as settled
     *
     * @param expenseId ID of the expense to settle
     * @return The settled expense
     */
    ExpenseDTO settleExpense(String expenseId);
}