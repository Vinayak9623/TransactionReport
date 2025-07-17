package com.transaction.service.impl;

import com.transaction.commonResponse.ApiResponse;
import com.transaction.dto.TransactionDto;
import com.transaction.entity.Transaction;
import com.transaction.repo.TransactionRepo;
import com.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public ResponseEntity<?> createTransaction(TransactionDto transactionDto) {
        var response=new ApiResponse<>();

        Transaction transaction=new Transaction();
        transaction.setMerchantName(transactionDto.getMerchantName());
        transaction.setAmount(transactionDto.getAmount());
        transactionRepo.save(transaction);

        response.responseMethod(HttpStatus.OK.value(), "Transaction create succesfully",null,null);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> getTransaction() {
        var response=new ApiResponse<>();
        List<Transaction> transactions = transactionRepo.findAll();
        response.responseMethod(HttpStatus.OK.value(), "Transaction repont succesfully find", transactions,null);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Transaction> getTransactionBetweenDate(LocalDate startDate, LocalDate endDate) {
        return transactionRepo.findAllByTransactionDateBetween(startDate, endDate);
    }

}
