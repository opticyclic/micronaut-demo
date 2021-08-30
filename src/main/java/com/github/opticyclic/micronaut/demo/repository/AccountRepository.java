package com.github.opticyclic.micronaut.demo.repository;

import com.github.opticyclic.micronaut.demo.model.Account;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
