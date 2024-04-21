package com.covinoc.crud.adapter.daos.JPA;

import com.covinoc.crud.adapter.daos.Entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity,Integer> {
}
