package com.covinoc.crud.adapter.daos.repossitoryImplement;


import com.covinoc.crud.adapter.daos.Entities.TransactionsEntity;
import com.covinoc.crud.adapter.daos.JPA.TransactionsJpaRepository;

import com.covinoc.crud.domain.model.Transactions;
import com.covinoc.crud.domain.ports.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsRepositoryImp implements TransactionsRepository {

    @Autowired
    private TransactionsJpaRepository transactionsJpaRepository;

    @Override
    public List<Transactions> getAll() {
        List<Transactions> transactions = new ArrayList<>();
        transactionsJpaRepository.findAll().forEach(transactionsEntity -> transactions.add(transactionsEntity.getTransactions()));
        return transactions;
    }

    @Override
    public Transactions save(Transactions transactions) {
      TransactionsEntity transactionsEntity = TransactionsEntity.of(transactions);
      transactionsJpaRepository.save(transactionsEntity);
      return transactions;
    }

    @Override
    public Transactions getTransactions(int idTransactions) {
        return transactionsJpaRepository.findById(idTransactions).get().getTransactions();
    }

    @Override
    public Transactions update(Transactions transactions) {
        return null;
    }
}
