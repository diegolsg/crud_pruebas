package com.covinoc.crud.domain.userCase;

import com.covinoc.crud.adapter.api.validation.Validation;
import com.covinoc.crud.adapter.daos.repossitoryImplement.AccountRepositoryImp;
import com.covinoc.crud.domain.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;


public class TransactionValidationImp implements Validation<Transactions> {
    @Autowired
    private AccountRepositoryImp accountRepositoryImp;
    public void validation(Transactions model) {
        if(model !=null){
            try {
            operation(model.getTransactionType(),model.getAmount(), model.getAccountDestination());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }
    public void operation(String operationType, double operationAmount,String operationAccount) {


    }


}
