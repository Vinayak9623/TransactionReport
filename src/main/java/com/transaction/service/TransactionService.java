package com.transaction.service;

import com.transaction.dto.TransactionDto;
import com.transaction.entity.Transaction;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    ResponseEntity<?> createTransaction(TransactionDto transactionDto);
    ResponseEntity<?> getTransaction();
    List<Transaction> getTransactionBetweenDate(LocalDate startDate, LocalDate endDate);
}
