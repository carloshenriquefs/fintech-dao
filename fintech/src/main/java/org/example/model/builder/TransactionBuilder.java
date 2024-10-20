package org.example.model.builder;

import org.example.model.Transaction;

import java.time.LocalDate;

public class TransactionBuilder {
    private Long code;
    private Long userId;
    private String transactionType;
    private String description;
    private Double valueTransaction;
    private LocalDate dataTransacao;

    public TransactionBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public TransactionBuilder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public TransactionBuilder setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public TransactionBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TransactionBuilder setValueTransaction(Double valueTransaction) {
        this.valueTransaction = valueTransaction;
        return this;
    }

    public TransactionBuilder setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
        return this;
    }

    public Transaction build() {
        return new Transaction(userId, transactionType, description, valueTransaction, dataTransacao);
    }
}
