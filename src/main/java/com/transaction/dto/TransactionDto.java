package com.transaction.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private String merchantName;
    private Double amount;
}
