package org.sid.ebankservice.repository;

import org.sid.ebankservice.entites.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
