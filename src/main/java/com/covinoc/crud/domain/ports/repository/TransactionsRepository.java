package com.covinoc.crud.domain.ports.repository;

import com.covinoc.crud.domain.model.Client;
import com.covinoc.crud.domain.model.Transactions;

import java.util.List;

public interface TransactionsRepository {
    List<Transactions> getAll();
    Transactions save(Transactions transactions);

    Transactions getTransactions(int idTransactions);
    Transactions update(Transactions transactions);
}
