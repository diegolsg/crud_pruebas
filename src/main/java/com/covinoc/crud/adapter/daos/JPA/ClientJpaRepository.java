package com.covinoc.crud.adapter.daos.JPA;

import com.covinoc.crud.adapter.daos.Entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity,Integer> {
}
