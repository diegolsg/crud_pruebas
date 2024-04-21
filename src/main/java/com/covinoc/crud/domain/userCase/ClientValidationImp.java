package com.covinoc.crud.domain.userCase;

import com.covinoc.crud.adapter.api.validation.Validation;
import com.covinoc.crud.domain.model.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ClientValidationImp implements Validation<Client> {
    @Override
    public void validation(Client model) {
        if(model !=null){
            try {
                validateAge(model.getBirthDate());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }
    public void validateAge(LocalDate dateAge)throws Exception{
        long diffDay = ChronoUnit.DAYS.between(dateAge,LocalDate.now());
        if ((diffDay/365.25)<=18){
            throw new Exception("error age");
        }
    }
}
