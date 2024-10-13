package org.example.model;

import java.time.LocalDate;

public class Transactions {

    private Long code;
    private Long codeUser;
    private String transactionType;
    private String description;
    private Double valueTransaction;
    private LocalDate dataTransacao;

    public Transactions() {
    }

    public Transactions(Long codeUser, String transactionType, String description, Double valueTransaction, LocalDate dataTransacao) {
        this.codeUser = codeUser;
        this.transactionType = transactionType;
        this.description = description;
        this.valueTransaction = valueTransaction;
        this.dataTransacao = dataTransacao;
    }

    public Transactions(Long code, Long codeUser, String transactionType, String description, Double valueTransaction, LocalDate dataTransacao) {
        this.code = code;
        this.codeUser = codeUser;
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

    public Long getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(Long codeUser) {
        this.codeUser = codeUser;
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
