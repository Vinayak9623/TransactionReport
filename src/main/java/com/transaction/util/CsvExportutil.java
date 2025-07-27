package com.transaction.util;

import com.transaction.entity.Transaction;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvExportutil {

    public static void writeTransactiontoCsv(List<Transaction> transactions, PrintWriter writer) {
        writer.println("ID,Merchant Name,Amount,Transaction Date");

        for (Transaction transaction : transactions) {
            writer.printf("%d,%s,%.2f,%s%n",
                    transaction.getId(),
                    transaction.getMerchantName(),
                    transaction.getAmount(),
                    transaction.getTransactionDate());
        }
    }
}
