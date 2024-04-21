package com.covinoc.crud.adapter.daos.repossitoryImplement;

import com.covinoc.crud.adapter.daos.Entities.ClientEntity;
import com.covinoc.crud.adapter.daos.JPA.ClientJpaRepository;
import com.covinoc.crud.domain.model.Client;
import com.covinoc.crud.domain.ports.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClientRepositoryImp implements ClientRepository {
    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        clientJpaRepository.findAll().forEach(clientEntity -> clients.add(clientEntity.getClient()));
        return clients;
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = ClientEntity.of(client);
        clientJpaRepository.save(clientEntity);
        return client;
    }

    @Override
    public void delete(int idClient) {
        clientJpaRepository.deleteById(idClient);

    }

    @Override
    public Client getClient(int idClient) {

        return clientJpaRepository.findById(idClient).get().getClient();
    }

    @Override
    public Client update(Client client) {
        Client client1 = getClient(client.getIdClient());
        if(client1 != null){
            client1.setIdentificationType(client.getIdentificationType()!=null? client.getIdentificationType():client1.getIdentificationType());
            client1.setFirstName(client.getFirstName()!=null?client.getFirstName():client1.getFirstName());
            client1.setLastName(client.getLastName()!=null?client.getLastName():client1.getLastName());
            client1.setEmail(client.getEmail()!=null?client.getEmail():client1.getEmail());
            client1.setIdenNumber(client.getIdenNumber()!=null?client.getIdenNumber():client1.getIdenNumber());
            client1.setBirthDate(client.getBirthDate()!=null?client.getBirthDate():client1.getBirthDate());
            client1.setModificationDate(client.getModificationDate()!=null?client.getModificationDate():client1.getModificationDate());
            ClientEntity clientEntity = ClientEntity.of(client1);
            clientJpaRepository.save(clientEntity);
            return client1;
        }else {
            return null;
        }
    }

}
