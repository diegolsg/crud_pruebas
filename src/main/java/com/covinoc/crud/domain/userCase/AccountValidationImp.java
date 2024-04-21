package com.covinoc.crud.domain.userCase;

import com.covinoc.crud.domain.model.Account;
import com.covinoc.crud.adapter.api.validation.Validation;
import org.springframework.stereotype.Service;

@Service
public class AccountValidationImp implements Validation<Account> {
    private static int number=0;

    public void validation(Account model) {
        if (model != null) {
            try {
                accountNum(model.getAccountType());
                validateSaving(model.getBalance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
    public String accountNum(String accountType){
        ++number;
        String numberWithZero = String.format("%08d",number);
        if (accountType.equals("ahorro")){
            return "53"+numberWithZero;
        } else if (accountType.equals("corriente")) {
            return "33"+numberWithZero;

        }
        return "0";
    }
    public void validateSaving(double balanceAccount)throws Exception{
        if(balanceAccount!=0){
            throw new Exception("error balance");

        }

    }
}
