package com.covinoc.crud.domain.ports.service;


import com.covinoc.crud.adapter.daos.repossitoryImplement.ClientRepositoryImp;
import com.covinoc.crud.domain.model.Client;
import com.covinoc.crud.domain.userCase.ClientValidationImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService{
    @Autowired
    private ClientRepositoryImp clientRepositoryImp;
    @Autowired
    private ClientValidationImp clientValidation;

    public Client save(Client client){
        client.setCreationDate(LocalDateTime.now());
        try {
            clientValidation.validateAge(client.getBirthDate());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  clientRepositoryImp.save(client);
    }
    public  Client getClient(int idClient){
        return  clientRepositoryImp.getClient(idClient);
    }

    public List<Client> getAll(){
        return clientRepositoryImp.getAll();
    }

    public Client update(Client client){
        client.setModificationDate(LocalDateTime.now());
        return clientRepositoryImp.update(client);}

    public boolean delete(int idClient){

        if(getClient(idClient)!=null){
            clientRepositoryImp.delete(idClient);
            return true;
        }else {
            return false;
        }
    }
}
