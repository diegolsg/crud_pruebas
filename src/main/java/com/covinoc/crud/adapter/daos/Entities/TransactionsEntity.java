package com.covinoc.crud.adapter.daos.Entities;

import com.covinoc.crud.domain.model.Transactions;
import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class TransactionsEntity {
    @Id
    @Column(name = "id_transaction")
    private Integer idTransactionEntity;
    @Column(name = "id_account")
    private Integer idAccountEntity;
    @Column(name = "transaction_type")
    private String transactionTypeEntity;
    @Column(name = "amount")
    private Double amountEntity;
    @Column(name = "account_destination")
    private String accountDestinationEntity;
    @ManyToOne
    @JoinColumn(name = "id_account",insertable = false,updatable = false)
    private AccountEntity accountEntity;

    public TransactionsEntity() {
    }

    public TransactionsEntity(Integer idTransactionEntity, Integer idAccountEntity, String transactionTypeEntity,
                              Double amountEntity, String accountDestinationEntity) {
        this.idTransactionEntity = idTransactionEntity;
        this.idAccountEntity = idAccountEntity;
        this.transactionTypeEntity = transactionTypeEntity;
        this.amountEntity = amountEntity;
        this.accountDestinationEntity = accountDestinationEntity;

    }

    public Transactions getTransactions(){
            return new Transactions(
                    this.idTransactionEntity,
                    this.idAccountEntity,
                    this.transactionTypeEntity,
                    this.amountEntity,
                    this.accountDestinationEntity,
                    this.accountEntity.getAccount()
            );
    }
    public static TransactionsEntity of(Transactions transactions){
        return new TransactionsEntity(
                transactions.getIdTransaction(),
                transactions.getIdAccount(),
                transactions.getTransactionType(),
                transactions.getAmount(),
                transactions.getAccountDestination()


        );
    }

    public Integer getIdTransactionEntity() {
        return idTransactionEntity;
    }

    public void setIdTransactionEntity(Integer idTransactionEntity) {
        this.idTransactionEntity = idTransactionEntity;
    }

    public Integer getIdAccountEntity() {
        return idAccountEntity;
    }

    public void setIdAccountEntity(Integer idAccountEntity) {
        this.idAccountEntity = idAccountEntity;
    }

    public String getTransactionTypeEntity() {
        return transactionTypeEntity;
    }

    public void setTransactionTypeEntity(String transactionTypeEntity) {
        this.transactionTypeEntity = transactionTypeEntity;
    }

    public Double getAmountEntity() {
        return amountEntity;
    }

    public void setAmountEntity(Double amountEntity) {
        this.amountEntity = amountEntity;
    }

    public String getAccountDestinationEntity() {
        return accountDestinationEntity;
    }

    public void setAccountDestinationEntity(String accountDestinationEntity) {
        this.accountDestinationEntity = accountDestinationEntity;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
