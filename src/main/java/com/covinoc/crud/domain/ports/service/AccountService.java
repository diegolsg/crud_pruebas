package com.covinoc.crud.domain.ports.service;

import com.covinoc.crud.adapter.daos.repossitoryImplement.AccountRepositoryImp;
import com.covinoc.crud.domain.model.Account;
import com.covinoc.crud.domain.userCase.AccountValidationImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepositoryImp accountRepositoryImp;
    @Autowired
    private AccountValidationImp accountValidationImp;
    public List<Account> getAll(){
        return accountRepositoryImp.getAll();
    }
    public Account getAccount(int accountNum){
        return accountRepositoryImp.getAccount(accountNum);
    }
    public boolean delete(int accountId){
        if(getAccount(accountId)!=null){
            accountRepositoryImp.delete(accountId);
            return true;
        }else {
            return false;
        }

    }
    public Account save(Account account){
        String number = accountValidationImp.accountNum(account.getAccountType());
        account.setAccountNumber(Long.parseLong(number));
        account.setAccountState("activo");
        return accountRepositoryImp.save(account);
    }

}
