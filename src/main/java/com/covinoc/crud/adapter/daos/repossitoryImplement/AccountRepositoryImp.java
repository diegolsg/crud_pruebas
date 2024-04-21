package com.covinoc.crud.adapter.daos.repossitoryImplement;

import com.covinoc.crud.adapter.daos.Entities.AccountEntity;

import com.covinoc.crud.adapter.daos.JPA.AccountJpaRepository;
import com.covinoc.crud.domain.model.Account;

import com.covinoc.crud.domain.ports.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountRepositoryImp implements AccountRepository {
    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        accountJpaRepository.findAll().forEach(accountEntity -> accounts.add(accountEntity.getAccount()));
        return accounts;
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = AccountEntity.of(account);
        accountJpaRepository.save(accountEntity);
        return account;
    }

    @Override
    public void delete(int accountId) {
        accountJpaRepository.deleteById(accountId);
    }

    @Override
    public Account getAccount(int accountId) {
        return accountJpaRepository.findById(accountId).get().getAccount();
    }
}
