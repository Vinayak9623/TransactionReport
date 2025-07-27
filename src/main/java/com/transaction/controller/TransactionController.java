package com.transaction.controller;

import com.transaction.dto.TransactionDto;
import com.transaction.entity.Transaction;
import com.transaction.service.TransactionService;
import com.transaction.util.CsvExportutil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
   private TransactionService service;

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transactionDto){
        return service.createTransaction(transactionDto);
    }


    @GetMapping("/get")
    public ResponseEntity<?> getTransaction(){
     return service.getTransaction();
    }

    @GetMapping("/download")
    public void downloadReport(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            HttpServletResponse response) throws IOException {

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=transaction_report.csv");
        List<Transaction> transactions = service.getTransactionBetweenDate(startDate, endDate);
        CsvExportutil.writeTransactiontoCsv(transactions,response.getWriter());
       // CsvExportutil.writeTransactionsToCsv(transactionBetweenDate, response.getWriter());
    }


}
