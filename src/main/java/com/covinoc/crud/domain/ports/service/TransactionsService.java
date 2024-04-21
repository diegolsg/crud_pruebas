package com.covinoc.crud.domain.ports.service;

import com.covinoc.crud.adapter.daos.repossitoryImplement.TransactionsRepositoryImp;
import com.covinoc.crud.domain.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionsService {
    @Autowired
    private TransactionsRepositoryImp transactionsRepositoryImp;
    public List<Transactions> getAll(){
        return transactionsRepositoryImp.getAll();
    }

}
