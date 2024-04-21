package com.covinoc.crud.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Account {
    private int idAccount;
    private int idClient;
    private String accountType;
    private long accountNumber;
    private String accountState;
    private double balance;
    private boolean exentGMF;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private Client client;


    public Account(int idAccount, int idClient, String accountType, long accountNumber,
                   String accountState, double balance, boolean exentGMF, LocalDateTime creationDate,
                   LocalDateTime modificationDate, Client client) {
        this.idAccount = idAccount;
        this.idClient = idClient;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountState = accountState;
        this.balance = balance;
        this.exentGMF = exentGMF;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.client = client;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isExentGMF() {
        return exentGMF;
    }

    public void setExentGMF(boolean exentGMF) {
        this.exentGMF = exentGMF;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
