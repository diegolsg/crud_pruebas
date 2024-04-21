package com.covinoc.crud.adapter.daos.Entities;

import com.covinoc.crud.domain.model.Account;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @Column(name = "id_account")
    private Integer idAccountEntity;
    @Column(name = "id_client")
    private Integer idClientEntity;
    @Column(name = "account_type")
    private String accountTypeEntity;
    @Column(name = "account_number")
    private Long accountNumberEntity;
    @Column(name = "account_state")
    private String accountStateEntity;
    @Column(name = "balance")
    private Double balanceEntity;
    @Column(name = "exent_gmf")
    private Boolean exentGMFEntity;
    @Column(name = "creation_date")
    private LocalDateTime creationDateEntity;
    @Column(name = "modification_date")
    private LocalDateTime modificationDateEntity;
    @ManyToOne
    @JoinColumn(name = "id_client",insertable = false,updatable = false)
    private ClientEntity clientEntity;

    @OneToMany(mappedBy = "accountEntity",cascade = {CascadeType.ALL})
    private List<TransactionsEntity> transactionsEntities;

    public AccountEntity() {
    }

    public AccountEntity(Integer idAccountEntity, Integer idClientEntity, String accountTypeEntity,
                         Long accountNumberEntity, String accountStateEntity, Double balanceEntity,
                         Boolean exentGMFEntity, LocalDateTime creationDateEntity, LocalDateTime modificationDateEntity
                         ) {
        this.idAccountEntity = idAccountEntity;
        this.idClientEntity = idClientEntity;
        this.accountTypeEntity = accountTypeEntity;
        this.accountNumberEntity = accountNumberEntity;
        this.accountStateEntity = accountStateEntity;
        this.balanceEntity = balanceEntity;
        this.exentGMFEntity = exentGMFEntity;
        this.creationDateEntity = creationDateEntity;
        this.modificationDateEntity = modificationDateEntity;


    }
    public Account getAccount(){
      return new Account(
                this.idAccountEntity,
                this.idClientEntity,
                this.accountTypeEntity,
                this.accountNumberEntity,
                this.accountStateEntity,
                this.balanceEntity,
                this.exentGMFEntity,
                this.creationDateEntity,
                this.modificationDateEntity,
                this.clientEntity.getClient()
        );
    }
    public static AccountEntity of(Account account){
        return new AccountEntity(
               account.getIdAccount(),
                account.getIdClient(),
                account.getAccountType(),
                account.getAccountNumber(),
                account.getAccountState(),
                account.getBalance(),
                account.isExentGMF(),
                account.getCreationDate(),
                account.getModificationDate()


        );
    }

    public Integer getIdAccountEntity() {
        return idAccountEntity;
    }

    public void setIdAccountEntity(Integer idAccountEntity) {
        this.idAccountEntity = idAccountEntity;
    }

    public Integer getIdClientEntity() {
        return idClientEntity;
    }

    public void setIdClientEntity(Integer idClientEntity) {
        this.idClientEntity = idClientEntity;
    }

    public String getAccountTypeEntity() {
        return accountTypeEntity;
    }

    public void setAccountTypeEntity(String accountTypeEntity) {
        this.accountTypeEntity = accountTypeEntity;
    }

    public Long getAccountNumberEntity() {
        return accountNumberEntity;
    }

    public void setAccountNumberEntity(Long accountNumberEntity) {
        this.accountNumberEntity = accountNumberEntity;
    }

    public String getAccountStateEntity() {
        return accountStateEntity;
    }

    public void setAccountStateEntity(String accountStateEntity) {
        this.accountStateEntity = accountStateEntity;
    }

    public Double getBalanceEntity() {
        return balanceEntity;
    }

    public void setBalanceEntity(Double balanceEntity) {
        this.balanceEntity = balanceEntity;
    }

    public Boolean getExentGMFEntity() {
        return exentGMFEntity;
    }

    public void setExentGMFEntity(Boolean exentGMFEntity) {
        this.exentGMFEntity = exentGMFEntity;
    }

    public LocalDateTime getCreationDateEntity() {
        return creationDateEntity;
    }

    public void setCreationDateEntity(LocalDateTime creationDateEntity) {
        this.creationDateEntity = creationDateEntity;
    }

    public LocalDateTime getModificationDateEntity() {
        return modificationDateEntity;
    }

    public void setModificationDateEntity(LocalDateTime modificationDateEntity) {
        this.modificationDateEntity = modificationDateEntity;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<TransactionsEntity> getTransactionsEntities() {
        return transactionsEntities;
    }

    public void setTransactionsEntities(List<TransactionsEntity> transactionsEntities) {
        this.transactionsEntities = transactionsEntities;
    }
}
