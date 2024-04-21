package com.covinoc.crud.adapter.daos.JPA;

import com.covinoc.crud.adapter.daos.Entities.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsJpaRepository extends JpaRepository<TransactionsEntity,Integer> {
}
