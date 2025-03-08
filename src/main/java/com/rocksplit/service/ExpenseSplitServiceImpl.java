package com.rocksplit.service;

import com.rocksplit.dto.BalanceDTO;
import com.rocksplit.dto.ExpenseDTO;
import com.rocksplit.model.Expense;
import com.rocksplit.model.User;
import com.rocksplit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseSplitServiceImpl implements ExpenseSplitService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BalanceDTO> calculateSplit(BigDecimal total, List<String> userIds, Expense.SplitType splitType, Map<String, BigDecimal> splitDetails) {
        //For Group expensis
        /*
        * get Group- Id
        * get SplitType:- Percentage / Equal
        * Verify all users are in the group
        * get User who paid
        * calculate the split for all user(including/excluding user who paid)
        * return balance DTO List to the requester
        */

        //For individual
        /*
        * make sure group-id is null
        * get SplitType:- Percentage / Equal
        * get User who paid
        * calculate the split for both user(including/excluding user who paid)
        * return balance DTO List to the requester
        */

        return List.of();
    }

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        return null;
    }

    @Override
    public ExpenseDTO updateExpense(ExpenseDTO expenseDTO) {
        return null;
    }

    @Override
    public ExpenseDTO settleExpense(String expenseId) {
        return null;
    }
}
