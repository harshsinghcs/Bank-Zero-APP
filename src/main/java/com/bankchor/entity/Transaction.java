package com.bankchor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private LocalDateTime createdAt;

    public Transaction() {}

    public Transaction(Long accountId, Double amount, TransactionType type) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
