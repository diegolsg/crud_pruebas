package com.covinoc.crud.domain.ports.repository;


import com.covinoc.crud.domain.model.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getAll();
    Client save(Client client);
    void delete(int idClient);
    Client getClient(int idClient);
    Client update(Client client);


}
