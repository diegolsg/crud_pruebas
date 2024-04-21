package com.covinoc.crud.domain.ports.repository;

import com.covinoc.crud.domain.model.Account;
import com.covinoc.crud.domain.model.Client;

import java.util.List;

public interface AccountRepository {
    List<Account> getAll();
    Account save(Account account);
    void delete(int accountId);
    Account getAccount(int accountId);

}
