package com.transaction.util;

import com.transaction.entity.Transaction;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvExportutil {

    public static void writeTransactiontoCsv(List<Transaction> transactions, HttpServletResponse response) throws IOException {

        PrintWriter writer=response.getWriter();
        writer.println("ID, Merchant, Amount,Date");

        for(Transaction txn:transactions){

            writer.printf("%d,%s,%.2f,%s%n",txn.getId(),txn.getMerchantName(),txn.getAmount(),txn.getTransactionDate());
        }
               writer.flush();
    }
}
