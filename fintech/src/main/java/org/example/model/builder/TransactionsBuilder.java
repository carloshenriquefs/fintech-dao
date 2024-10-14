package org.example.model.builder;

import org.example.model.Transactions;

import java.time.LocalDate;

public class TransactionsBuilder {

    private Long code;
    private Long codeUser;
    private String transactionType;
    private String description;
    private Double valueTransaction;
    private LocalDate dataTransacao;

    public TransactionsBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public TransactionsBuilder setCodeUser(Long codeUser) {
        this.codeUser = codeUser;
        return this;
    }

    public TransactionsBuilder setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public TransactionsBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TransactionsBuilder setValueTransaction(Double valueTransaction) {
        this.valueTransaction = valueTransaction;
        return this;
    }

    public TransactionsBuilder setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
        return this;
    }

    public Transactions build() {
        return new Transactions(code, codeUser, transactionType, description, valueTransaction, dataTransacao);
    }
}
