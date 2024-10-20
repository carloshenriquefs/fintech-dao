package org.example.model;

import java.time.LocalDate;

public class Transaction {

    private Long code;
    private Long userId;
    private String transactionType;
    private String description;
    private Double valueTransaction;
    private LocalDate dataTransacao;

    public Transaction(Long userId, String transactionType, String description, Double valueTransaction, LocalDate dataTransacao) {
        this.userId = userId;
        this.transactionType = transactionType;
        this.description = description;
        this.valueTransaction = valueTransaction;
        this.dataTransacao = dataTransacao;
    }

    public Transaction(Long code, Long userId, String transactionType, String description, Double valueTransaction, LocalDate dataTransacao) {
        this.code = code;
        this.userId = userId;
        this.transactionType = transactionType;
        this.description = description;
        this.valueTransaction = valueTransaction;
        this.dataTransacao = dataTransacao;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValueTransaction() {
        return valueTransaction;
    }

    public void setValueTransaction(Double valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
