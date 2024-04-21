package com.covinoc.crud.domain.model;

public class Transactions {
    private int idTransaction;
    private int idAccount;
    private String transactionType;
    private double amount;
    private String accountDestination;
    private Account account;

    public Transactions(int idTransaction, int idAccount, String transactionType,
                        double amount, String accountDestination, Account account) {
        this.idTransaction = idTransaction;
        this.idAccount = idAccount;
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountDestination = accountDestination;
        this.account = account;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(String accountDestination) {
        this.accountDestination = accountDestination;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
